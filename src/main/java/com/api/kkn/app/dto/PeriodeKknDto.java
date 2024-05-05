package com.api.kkn.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PeriodeKknDto {
    Integer id_periode_kkn;

    @NotBlank(message = "Tahun Akademik Tidak Boleh Kosong")
    @Size(max = 10,message = "Tahun akademik minimal 4 dan maksimal 10")
    String tahun_akademik;

    @NotBlank(message = "Angkatan Tidak Boleh Kosong")
    @Size(max = 10,message = "Angkatan minimal 4 dan maksimal 10")
    String angkatan;
    Integer status;
    Integer status_pendaftaran;
    Date tgl_akademik;
    Date tgl_mulai;
    Date tgl_selesai;
}
