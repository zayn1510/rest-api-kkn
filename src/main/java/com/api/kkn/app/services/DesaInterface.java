package com.api.kkn.app.services;

import com.api.kkn.app.dto.DesaDto;
import com.api.kkn.app.entity.Desa;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.ResponseApi;
import org.springframework.http.ResponseEntity;

public interface DesaInterface {
        ResponseEntity<DataResponse> showDesa(Integer pagenumber, Integer pagesize);
        ResponseEntity<ResponseApi> createDesa(DesaDto desaDto);
        ResponseEntity<ResponseApi> updateDesa(DesaDto desaDto,Integer id);
        ResponseEntity<ResponseApi> deleteDesa(Integer id);
}
