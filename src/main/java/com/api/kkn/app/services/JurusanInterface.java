package com.api.kkn.app.services;

import com.api.kkn.app.dto.JurusanDto;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.ResponseApi;
import org.springframework.http.ResponseEntity;

public interface JurusanInterface {

    ResponseEntity<DataResponse> get_data(Integer pageNumber,Integer pageSize);
    ResponseEntity<ResponseApi> insert_data(JurusanDto jurusanDto);
    ResponseEntity<ResponseApi> update_data(Integer id,JurusanDto jurusanDto);

    ResponseEntity<ResponseApi> delete_data(Integer id);
}
