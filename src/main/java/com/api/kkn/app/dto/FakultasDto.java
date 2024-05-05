package com.api.kkn.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FakultasDto {
    public Integer id_fakultas;

    @NotBlank(message = "Kode Fakultas Masih Kosong")
    public String kode_fakultas;

    @NotBlank(message ="Nama Fakultas Masih Kosong")
    public String nama_fakultas;
}
