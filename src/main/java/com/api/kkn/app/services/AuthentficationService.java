package com.api.kkn.app.services;

import com.api.kkn.app.dto.RefreshTokenDto;
import com.api.kkn.app.dto.SignInDto;
import com.api.kkn.app.dto.SignUpDto;
import com.api.kkn.app.entity.Mahasiswa;
import com.api.kkn.app.entity.Role;
import com.api.kkn.app.entity.Users;
import com.api.kkn.app.repository.MahasiswaRepository;
import com.api.kkn.app.repository.UserRepository;
import com.api.kkn.app.response.LoginResponse;
import com.api.kkn.app.response.ResponseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthentficationService implements AuthentificationInterface {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final MahasiswaRepository mahasiswaRepository;
    @Override
    public ResponseEntity<ResponseApi> signUp(SignUpDto signup) {
        Mahasiswa mahasiswa=mahasiswaRepository.findByNimMhs(signup.getNim());
        Integer idmahasiswa=0;
        if (mahasiswa != null) {
            Users users= userRepository.findByIdPengguna(mahasiswa.getIdMhs());
            idmahasiswa=mahasiswa.getIdMhs();
            if(users !=null){
                return new ResponseEntity<>(new ResponseApi("user ini telah ada",false),HttpStatus.OK);
            }
            Users user = new Users();
            user.setEmail(signup.getEmail());
            user.setPassword(passwordEncoder.encode(signup.getPassword()));
            user.setUsername(signup.getUsername());
            user.setRole(Role.USER);
            user.setIdPengguna(idmahasiswa);
            userRepository.save(user);
            return new ResponseEntity<>(new ResponseApi("success",true), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseApi("nim tidak ditemukan",false),HttpStatus.OK);
    }

    public ResponseEntity<LoginResponse> login(SignInDto signIn) {

        var checkemail=userRepository.findByEmail(signIn.getEmail());
        if(checkemail.isEmpty()){
            return new ResponseEntity<>(new LoginResponse("login gagal",false,null,null),HttpStatus.OK);
        }
        var user=userRepository.findByEmail(signIn.getEmail()).orElseThrow();
        var jwt=jwtService.generateToken(user);
        var refreshToken=jwtService.generateRefreshToken(new HashMap<>(),user);
        user.setToken(jwt);
        userRepository.save(user);
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), signIn.getPassword()));
            return new ResponseEntity<>(new LoginResponse("Login berhasil",true,jwt,refreshToken),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new LoginResponse(e.getMessage(),false,null,null),HttpStatus.OK);
        }
    }
    @Override
    public LoginResponse refreshTOken(RefreshTokenDto refreshToken) {
                String username=jwtService.extractUsername(refreshToken.getToken());
        LoginResponse loginResponse=new LoginResponse();
        Users user=userRepository.findByUsername(username).orElseThrow(()->new IllegalArgumentException("invalid email"));
        if(jwtService.validateToken(refreshToken.getToken(),user)){
            var jwt=jwtService.generateToken(user);
            loginResponse.setToken(jwt);
            loginResponse.setRefreshToken(refreshToken.getToken());
        }
        return loginResponse;
    }

    @Override
    public ResponseEntity<ResponseApi> createAdmin(SignUpDto sign) {
        Users user = new Users();
        user.setEmail(sign.getEmail());
        user.setPassword(passwordEncoder.encode(sign.getPassword()));
        user.setUsername(sign.getUsername());
        user.setRole(Role.ADMIN);
        user.setIdPengguna(0);
        userRepository.save(user);
        return new ResponseEntity<>(new ResponseApi("success",true), HttpStatus.OK);
    }
}
