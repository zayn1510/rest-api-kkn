package com.api.kkn.app.response;


import com.api.kkn.app.entity.Jurusan;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FakultasResponse {
    Integer id_fakultas;
    String kode_fakultas;
    String nama_fakultas;
}
