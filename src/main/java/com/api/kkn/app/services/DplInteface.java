package com.api.kkn.app.services;

import com.api.kkn.app.dto.DplDto;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.ResponseApi;
import org.springframework.http.ResponseEntity;

public interface DplInteface {
    ResponseEntity<ResponseApi> createDpl(DplDto dplDto);
    ResponseEntity<DataResponse> showDpl(Integer pagenumber, Integer pagesize);
    ResponseEntity<Object> updateDpl(DplDto dplDto,Integer id);
    ResponseEntity<ResponseApi> deleteDpl(Integer id);
}
