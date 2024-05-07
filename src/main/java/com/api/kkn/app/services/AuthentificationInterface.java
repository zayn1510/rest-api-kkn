package com.api.kkn.app.services;

import com.api.kkn.app.dto.RefreshTokenDto;
import com.api.kkn.app.dto.SignInDto;
import com.api.kkn.app.dto.SignUpDto;
import com.api.kkn.app.entity.Users;
import com.api.kkn.app.response.LoginResponse;
import com.api.kkn.app.response.ResponseApi;
import org.springframework.http.ResponseEntity;

public interface AuthentificationInterface {
    ResponseEntity<ResponseApi> signUp(SignUpDto sign);
    ResponseEntity<LoginResponse> login(SignInDto sign);
    LoginResponse refreshTOken(RefreshTokenDto refresh);
    ResponseEntity<ResponseApi> createAdmin(SignUpDto sign);

}
