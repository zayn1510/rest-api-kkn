package com.api.kkn.app.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PeriodeKknResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer id_periode_kkn;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String tahun_akademik;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String angkatan;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer status_pendaftaran;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Date tgl_akademik;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Date tgl_mulai;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Date tgl_selesai;

}
