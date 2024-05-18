package com.api.kkn.app.services;

import com.api.kkn.app.dto.MahasiswaDto;
import com.api.kkn.app.entity.Mahasiswa;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.MahasiswaResponse;
import com.api.kkn.app.response.ResponseApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MahasiswaInterface {
    ResponseEntity<ResponseApi> insertMahasiswa(MahasiswaDto mahasiswaDto, MultipartFile multipartFile) throws Exception;
    ResponseEntity<ResponseApi> updateMahasiswa(MahasiswaDto mahasiswaDto,MultipartFile file);
    ResponseEntity<ResponseApi> deleteMahasiswa(Integer id);
    ResponseEntity<DataResponse> getMahasiswa(Integer pagenumber, Integer pagesize);
    List<MahasiswaResponse> loadDataFromDatabase(Integer pagenumber, Integer pagesize);
    List<MahasiswaResponse> loadDataFromCache(Integer pagenumber, Integer pagesize);
}
