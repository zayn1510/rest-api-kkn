package com.api.kkn.app.services;

import com.api.kkn.app.dto.JurusanDto;
import com.api.kkn.app.entity.Fakultas;
import com.api.kkn.app.entity.Jurusan;
import com.api.kkn.app.repository.JurusanRepository;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.FakultasResponse;
import com.api.kkn.app.response.JurusanResponse;
import com.api.kkn.app.response.ResponseApi;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JurusanService implements JurusanInterface {
    private final JurusanRepository jurusanRepository;
    @Override
    public ResponseEntity<DataResponse> get_data(Integer pageNumber,Integer pageSize) {

        Pageable pageable= PageRequest.of(pageNumber,pageSize,Sort.by(Sort.Direction.DESC,"idJurusan"));
        Page<Jurusan> data = jurusanRepository.findAll(pageable);
        List< JurusanResponse> list=new ArrayList<>();
        for(Jurusan jurusan:data){
            JurusanResponse jurusanResponse=new JurusanResponse();
            jurusanResponse.setId_jurusan(jurusan.getIdJurusan());
            jurusanResponse.setKode_jurusan(jurusan.getKodeJurusan());
            jurusanResponse.setNama_jurusan(jurusan.getNamaJurusan());
            Fakultas fakultas=jurusan.getFakultas();
            FakultasResponse fakultasResponse=new FakultasResponse(fakultas.getIdFakultas(),fakultas.getKodeFakultas(),fakultas.getNamaFakultas());
            jurusanResponse.setFakultas(fakultasResponse);
            list.add(jurusanResponse);
        }
        return new ResponseEntity<>(new DataResponse("success",true,list),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi> insert_data(JurusanDto jurusanDto) {
        Jurusan jurusan=new Jurusan();
        jurusan.setKodeJurusan(jurusanDto.getKode_jurusan());
        jurusan.setNamaJurusan(jurusanDto.getNama_jurusan());
        Fakultas fakultas=new Fakultas();
        fakultas.setIdFakultas(jurusanDto.getId_fakultas());
        jurusan.setFakultas(fakultas);
        jurusanRepository.save(jurusan);
        return new ResponseEntity<>(new ResponseApi("success",true),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseApi> update_data(Integer id, JurusanDto jurusanDto) {
        // check first data exist or not
        if(jurusanRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(new ResponseApi("data not found",false),HttpStatus.NOT_FOUND);
        }

        // set up data to update
        Jurusan jurusanModel=jurusanRepository.findById(id).get();
        jurusanModel.setKodeJurusan(jurusanDto.getKode_jurusan());
        jurusanModel.setNamaJurusan(jurusanDto.getNama_jurusan());
        jurusanRepository.save(jurusanModel);
        return new ResponseEntity<>(new ResponseApi("success",true),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseApi> delete_data(Integer id) {
        // check first data exist or not
        if(jurusanRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(new ResponseApi("data not found",false),HttpStatus.NOT_FOUND);
        }
        jurusanRepository.deleteById(id);
        return new ResponseEntity<>(new ResponseApi("success",true),HttpStatus.OK);
    }
}
