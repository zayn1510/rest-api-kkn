package com.api.kkn.app.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class DesaResponse {
    private Integer id;
    private String desa;
    private String kecamatan;
    private String kabupaten;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PeriodeKknResponse periodekkn;
}
