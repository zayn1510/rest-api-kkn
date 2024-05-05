package com.api.kkn.app.services;

import com.api.kkn.app.dto.FakultasDto;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.FakultasResponse;
import com.api.kkn.app.response.ResponseApi;
import org.springframework.http.ResponseEntity;

public interface FakultasInterface {
    DataResponse get_data(Integer pageNumber,Integer pageSize);
    ResponseApi insert_data(FakultasDto fakultasDto);
    ResponseApi update_data(Integer id,FakultasDto fakultasDto);
    ResponseApi delete_data(Integer id);
    Object get_data_by_kode_fakultas(String kode);
}
