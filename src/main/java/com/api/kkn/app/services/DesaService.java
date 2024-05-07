package com.api.kkn.app.services;

import com.api.kkn.app.dto.DesaDto;
import com.api.kkn.app.entity.Desa;
import com.api.kkn.app.mapper.DesaMapper;
import com.api.kkn.app.repository.DesaRepository;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.DesaResponse;
import com.api.kkn.app.response.PeriodeKknResponse;
import com.api.kkn.app.response.ResponseApi;
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
public class DesaService implements DesaInterface{

    private final DesaRepository desaRepository;
    @Override
    public ResponseEntity<DataResponse> showDesa(Integer pagenumber, Integer pagesize) {
        Pageable pageable= PageRequest.of(pagenumber,pagesize, Sort.by(Sort.Direction.DESC,"idDesa"));
        Page<Desa> data=desaRepository.findAll(pageable);
        List<DesaResponse> list=new ArrayList<>();
        for(Desa desa:data){
            DesaResponse desaResponse=new DesaResponse();
            desaResponse.setId(desa.getIdDesa());
            desaResponse.setDesa(desa.getDesa());
            desaResponse.setKecamatan(desa.getKecamatan());
            desaResponse.setKabupaten(desa.getKabupaten());
            PeriodeKknResponse periodeKknResponse=new PeriodeKknResponse();
            periodeKknResponse.setTahun_akademik(desa.getIdPeriode().getTahunAkademik());
            periodeKknResponse.setAngkatan(desa.getIdPeriode().getAngkatan());
            desaResponse.setPeriodekkn(periodeKknResponse);
            list.add(desaResponse);
        }
        return new ResponseEntity<>(new DataResponse("success",true,list), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi> createDesa(DesaDto desaDto) {
        Desa desa= DesaMapper.toDesa(desaDto);
        desaRepository.save(desa);
        return new ResponseEntity<>(new ResponseApi("success",true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi> updateDesa(DesaDto desaDto, Integer id) {
        ResponseEntity<ResponseApi> response;
        response=new ResponseEntity<>(new ResponseApi("data tidak ditemukan",false), HttpStatus.NOT_FOUND);
        if(desaRepository.existsById(id)){
           Desa desa=desaRepository.findById(id).get();
           DesaMapper.update(desa,desaDto);
           desaRepository.save(desa);
           response = new ResponseEntity<>(new ResponseApi("success",true), HttpStatus.OK);
        }
        return response;
    }

    @Override
    public ResponseEntity<ResponseApi> deleteDesa(Integer id) {
        ResponseEntity<ResponseApi> response;
        response=new ResponseEntity<>(new ResponseApi("data tidak ditemukan",false), HttpStatus.NOT_FOUND);
        if(desaRepository.existsById(id)){
            desaRepository.deleteById(id);
            response = new ResponseEntity<>(new ResponseApi("success",true), HttpStatus.OK);
        }
        return response;
    }
}
