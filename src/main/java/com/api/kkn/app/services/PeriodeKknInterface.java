package com.api.kkn.app.services;

import com.api.kkn.app.dto.PeriodeKknDto;
import com.api.kkn.app.entity.PeriodeKkn;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.JurusanResponse;
import com.api.kkn.app.response.PeriodeKknResponse;
import com.api.kkn.app.response.ResponseApi;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PeriodeKknInterface {
    ResponseEntity<DataResponse> get_data(Integer pageNumber, Integer pageSize);
    ResponseEntity<ResponseApi> insert_data(PeriodeKknDto periodeKknDto);
    ResponseEntity<ResponseApi> update_data(Integer id,PeriodeKknDto periodeKknDto);
    ResponseEntity<ResponseApi> delete_data(Integer id);
    List<PeriodeKknResponse> loadDataFromDatabase(Integer pagenumber, Integer pageSize);
    List<PeriodeKknResponse> loadDataFromCache(Integer pagenumber, Integer pageSize);
    List<PeriodeKknResponse> loadResponseJurusan(Page<PeriodeKkn> page);
}
