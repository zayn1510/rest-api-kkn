package com.api.kkn.app.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MahasiswaResponse {
    Integer id_mhs;
    String nim_mhs;
    String nama_mhs;
    String tempat_lahir_mhs;
    Date tgl_lahir_mhs;
    String nomor_hp_mhs;
    String email_mhs;
    String angkatan_mhs;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    JurusanResponse jurusan;
}
