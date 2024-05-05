package com.api.kkn.app.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DplDto {
    private Integer id_periode_kkn;
    @NotBlank(message = "Nidn tidak boleh kosong")
    @Pattern(regexp = "^[0-9]*$", message = "NIDN tidak boleh kosong")
    @Size(min = 4,max = 20,message = "Maksimal 20 karakter")
    private String nidn;
    @NotBlank(message = "Nama dosen tidak boleh kosong")
    private String nama_dosen;
    @NotBlank(message = "Gelar depan tidak boleh kosong")
    private String gelar_depan;
    @NotBlank(message = "Gelar belakang tidak boleh kosong")
    private String gelar_belakang;
    @NotBlank(message = "Nomor Handphone tidak boleh kosong")
    @Size(min = 12,message = "Maksimal 12 Angka")
    @Pattern(regexp = "^[0-9]*$", message = "Nomor handphone tidak boleh kosong")
    private String nomor_hp;
    @NotBlank(message = "Email tidak boleh kosong")
    @Email(message = "Format Email")
    private String email;
}
