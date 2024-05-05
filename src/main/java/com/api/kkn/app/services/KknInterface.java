package com.api.kkn.app.services;

import com.api.kkn.app.dto.KknDto;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.ResponseApi;
import org.springframework.http.ResponseEntity;

public interface KknInterface {
    ResponseEntity<ResponseApi> createData(KknDto kknDto);
    ResponseEntity<DataResponse> showData(Integer pagenumber, Integer pagesize);
    ResponseEntity<ResponseApi> deleteData(Integer id);
}
