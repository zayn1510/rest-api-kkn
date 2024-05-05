package com.api.kkn.app.response;

import com.api.kkn.app.entity.Mahasiswa;
import com.api.kkn.app.entity.PeriodeKkn;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class KknResponse {
    private int id;

    private MahasiswaResponse mahasiswa;
    private PeriodeKknResponse periode;
    private String kode_calon_kkn;
    private String desa;
    private String kecamatan;
    private String kabupaten;
    private Boolean status;
    private Boolean group;
    private Timestamp created_at;
    private Timestamp updated_at;

}
