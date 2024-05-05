package com.api.kkn.app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInDto {
    private String email;
    private String password;
}
