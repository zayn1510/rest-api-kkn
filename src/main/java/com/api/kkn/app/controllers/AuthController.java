package com.api.kkn.app.controllers;

import com.api.kkn.app.dto.RefreshTokenDto;
import com.api.kkn.app.dto.SignInDto;
import com.api.kkn.app.dto.SignUpDto;
import com.api.kkn.app.entity.Users;
import com.api.kkn.app.response.LoginResponse;
import com.api.kkn.app.response.ResponseApi;
import com.api.kkn.app.services.AuthentficationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthentficationService authentficationService;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome";
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseApi> signup(@Valid  @RequestBody SignUpDto signUpDto) {
        return authentficationService.signUp(signUpDto);
    }
    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> signin(@RequestBody SignInDto signInDto) {
        return authentficationService.login(signInDto);
    }
    @PostMapping("/refresh")
    public ResponseEntity<LoginResponse> refreshToken(@RequestBody RefreshTokenDto refreshTokenDto) {
        return ResponseEntity.ok(authentficationService.refreshTOken(refreshTokenDto));
    }

    @PostMapping("/createadmin")
    public ResponseEntity<ResponseApi> createAdmin(@Valid @RequestBody SignUpDto signUpDto) {
        return authentficationService.createAdmin(signUpDto);
    }






}
