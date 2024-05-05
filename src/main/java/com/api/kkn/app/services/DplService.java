package com.api.kkn.app.services;

import com.api.kkn.app.dto.DplDto;
import com.api.kkn.app.entity.Dpl;
import com.api.kkn.app.mapper.DplMapper;
import com.api.kkn.app.repository.DplRepository;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.DplResponse;
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
public class DplService implements DplInteface{

    private final DplRepository dplRepository;
    @Override
    public ResponseEntity<ResponseApi> createDpl(DplDto dplDto) {
        Dpl dpl = DplMapper.toDpl(dplDto);
        dplRepository.save(dpl);
        return new ResponseEntity<>(new ResponseApi("success",true), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<DataResponse> showDpl(Integer pagenumber, Integer pagesize) {
        Pageable pageable= PageRequest.of(pagenumber,pagesize, Sort.by(Sort.Direction.DESC,"idDpl"));
        Page<Dpl> data = dplRepository.findAll(pageable);
        List<DplResponse> list=new ArrayList<>();
        for(Dpl dpl : data){
            DplResponse dplResponse = new DplResponse();
            dplResponse.setNidn(dpl.getNidn());
            dplResponse.setNama_dosen(dpl.getNamaDosen());
            dplResponse.setEmail(dpl.getEmail());
            dplResponse.setGelar_depan(dpl.getGelarDepan());
            dplResponse.setGelar_belakang(dpl.getGelarBelakang());
            dplResponse.setNomor_hp(dpl.getNomorHp());
            dplResponse.setCreated_at(dpl.getCreatedAt());
            dplResponse.setUpdated_at(dpl.getUpdatedAt());
            PeriodeKknResponse periodeKknResponse=new PeriodeKknResponse();
            periodeKknResponse.setId_periode_kkn(dpl.getPeriodeKkn().getIdPeriodeKkn());
            periodeKknResponse.setAngkatan(dpl.getPeriodeKkn().getAngkatan());
            periodeKknResponse.setStatus(dpl.getPeriodeKkn().getStatus());
            periodeKknResponse.setTahun_akademik(dpl.getPeriodeKkn().getTahunAkademik());
            dplResponse.setPeriode_kkn(periodeKknResponse);
            list.add(dplResponse);
        }
        return new ResponseEntity<>(new DataResponse("success",true,list),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> updateDpl(DplDto dplDto, Integer id) {
        if(dplRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(new ResponseApi("data tidak ditemukan",false),HttpStatus.NOT_FOUND);
        }
        Dpl dpl=dplRepository.findById(id).get();
        DplMapper.updateDto(dpl,dplDto);
        dplRepository.save(dpl);
        return new ResponseEntity<>(new ResponseApi("success",true),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi> deleteDpl(Integer id) {
        if(dplRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(new ResponseApi("data tidak ditemukan",false),HttpStatus.NOT_FOUND);
        }
        dplRepository.deleteById(id);
        return new ResponseEntity<>(new ResponseApi("success",true),HttpStatus.OK);
    }


}
