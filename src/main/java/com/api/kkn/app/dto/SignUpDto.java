package com.api.kkn.app.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpDto {

    @Pattern(regexp = "^[0-9]*$", message = "Nim hanya terdiri dari angka")
    private String nim;
    @NotBlank(message = "Username tidak boleh kosong")
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9_]*$", message = "Username harus dimulai dengan huruf kapital dan terdiri dari huruf kapital, huruf kecil, angka, dan garis bawah")
    private String username;

    @Email(message = "Bukan Format Email")
    private String email;
    private String password;
}
