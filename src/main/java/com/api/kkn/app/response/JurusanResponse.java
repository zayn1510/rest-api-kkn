package com.api.kkn.app.response;

import com.api.kkn.app.entity.Fakultas;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JurusanResponse {
    Integer id_jurusan;
    String kode_jurusan;
    String nama_jurusan;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    FakultasResponse fakultas;
}
