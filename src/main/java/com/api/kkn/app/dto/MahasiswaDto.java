package com.api.kkn.app.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@Builder
public class MahasiswaDto {

    @NotBlank(message = "Nim tidak boleh kosong")
    @Size(min = 4,max = 12,message = "minmal 4 sampai 12 angka")
    @Pattern(regexp = "^[0-9]*$", message = "Nim harus angka")
    private String nimMhs;

    @NotBlank(message = "Nama tidak boleh kosong")
    private String namaMhs;

    @NotBlank(message = "Tempat lahir tidak boleh kosong")
    private String tempatLahirMhs;

    private String tglLahirMhs;

    @NotBlank(message = "Nomor handphone tidak boleh kosong")
    @Pattern(regexp = "^[0-9]*$", message = "Nomor handphone tidak boleh kosong")
    private String nomorHpMhs;

    @NotBlank(message = "Email tidak boleh kosong")
    @Email(message = "Format Email")
    private String emailMhs;

    @NotBlank(message = "Angkatan tidak boleh kosong")
    @Pattern(regexp = "^[0-9]*$", message = "Angkatan tidak boleh kosong")
    private String angkatanMhs;
    private Integer idFakultas;
    private Integer idJurusan;
    private String fotoMhs;
}
