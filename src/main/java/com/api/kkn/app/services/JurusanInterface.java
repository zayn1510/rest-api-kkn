package com.api.kkn.app.services;

import com.api.kkn.app.dto.JurusanDto;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.FakultasResponse;
import com.api.kkn.app.response.JurusanResponse;
import com.api.kkn.app.response.ResponseApi;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JurusanInterface {

    ResponseEntity<DataResponse> get_data(Integer pageNumber,Integer pageSize);
    ResponseEntity<ResponseApi> insert_data(JurusanDto jurusanDto);
    ResponseEntity<ResponseApi> update_data(Integer id,JurusanDto jurusanDto);
    ResponseEntity<ResponseApi> delete_data(Integer id);
    List<JurusanResponse> loadFromDatabase(Integer pageNumber, Integer pageSize);
    List<JurusanResponse> loadFromCache(Integer pageNumber, Integer pageSize);
}
