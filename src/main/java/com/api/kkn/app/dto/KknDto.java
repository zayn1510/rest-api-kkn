package com.api.kkn.app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KknDto {
    private Integer mhs;
    private Integer periode_kkn;

    @NotBlank(message = "Desa tidak boleh kosong")
    private String desa;
    @NotBlank(message = "Kecamatan tidak boleh kosong")
    private String kecamatan;
    @NotBlank(message = "Kabupten tidak boleh kosong")
    private String kabupaten;

    private Boolean status;
    private Boolean group;
}
