package com.api.kkn.app.services;

import com.api.kkn.app.dto.PeriodeKknDto;
import com.api.kkn.app.entity.PeriodeKkn;
import com.api.kkn.app.mapper.PeriodeKknMapper;
import com.api.kkn.app.repository.PeriodeKknRepository;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.PeriodeKknResponse;
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
public class PeriodeKknService implements PeriodeKknInterface{
    private final PeriodeKknRepository periodeKknRepository;
    @Override
    public ResponseEntity<DataResponse> get_data(Integer pageNumber, Integer pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize,Sort.by(Sort.Direction.DESC,"idPeriodeKkn"));
        Page<PeriodeKkn> page=periodeKknRepository.findAll(pageable);
        List<PeriodeKknResponse> list=new ArrayList<>();
        for(PeriodeKkn periodeKkn:page){
            PeriodeKknResponse periodeKknResponse=new PeriodeKknResponse();
            periodeKknResponse.setId_periode_kkn(periodeKkn.getIdPeriodeKkn());
            periodeKknResponse.setTahun_akademik(periodeKkn.getTahunAkademik());
            periodeKknResponse.setAngkatan(periodeKkn.getAngkatan());
            periodeKknResponse.setStatus(periodeKkn.getStatus());
            periodeKknResponse.setStatus_pendaftaran(periodeKkn.getStatusPendaftaran());
            periodeKknResponse.setTgl_akademik(periodeKkn.getTglAkademik());
            periodeKknResponse.setTgl_mulai(periodeKkn.getTglMulai());
            periodeKknResponse.setTgl_selesai(periodeKkn.getTglSelesai());
            list.add(periodeKknResponse);
        }


        return new ResponseEntity<>(new DataResponse("success",true,list), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi> insert_data(PeriodeKknDto periodeKknDto) {
        PeriodeKkn periodeKkn= PeriodeKknMapper.mapEntityToDto(periodeKknDto);
        periodeKknRepository.save(periodeKkn);
        return new ResponseEntity<>(new ResponseApi("success",true),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseApi> update_data(Integer id, PeriodeKknDto periodeKknDto) {
        if(periodeKknRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(new ResponseApi("ID invalid",true),HttpStatus.NOT_FOUND);
        }
        PeriodeKkn periodeKkn=periodeKknRepository.findById(id).get();
        PeriodeKknMapper.updateDtoToEntity(periodeKknDto, periodeKkn);
        periodeKknRepository.save(periodeKkn);

        return new ResponseEntity<>(new ResponseApi("success",true),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseApi> delete_data(Integer id) {
        if(periodeKknRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(new ResponseApi("ID invalid",true),HttpStatus.NOT_FOUND);
        }
        periodeKknRepository.deleteById(id);
        return new ResponseEntity<>(new ResponseApi("success",true),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> get_data_by_kode_fakultas(String kode) {
        return null;
    }
}
