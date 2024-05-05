package com.api.kkn.app.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JurusanDto {

    Integer id_jurusan;
    Integer id_fakultas;

    @NotBlank(message = "Kode Jurusan Tidak Boleh Kosong")
    @Size(min = 4,max = 10,message = "Kode Jurusan harus minimal 6 dan maksimal 10")
    String kode_jurusan;

    @NotBlank(message = "Nama Jurusan Tidak Boleh Kosong")
    String nama_jurusan;
}
