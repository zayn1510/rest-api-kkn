package com.api.kkn.app.services;

import com.api.kkn.app.dto.PeriodeKknDto;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.ResponseApi;
import org.springframework.http.ResponseEntity;

public interface PeriodeKknInterface {
    ResponseEntity<DataResponse> get_data(Integer pageNumber, Integer pageSize);
    ResponseEntity<ResponseApi> insert_data(PeriodeKknDto periodeKknDto);
    ResponseEntity<ResponseApi> update_data(Integer id,PeriodeKknDto periodeKknDto);

    ResponseEntity<ResponseApi> delete_data(Integer id);

    ResponseEntity<?> get_data_by_kode_fakultas(String kode);
}
