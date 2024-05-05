package com.api.kkn.app.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DplResponse {
    private String nidn;
    private String nama_dosen;
    private String gelar_depan;
    private String gelar_belakang;
    private String nomor_hp;
    private String email;
    private Timestamp created_at;
    private Timestamp updated_at;
    private PeriodeKknResponse periode_kkn;
}
