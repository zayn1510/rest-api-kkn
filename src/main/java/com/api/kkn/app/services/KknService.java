package com.api.kkn.app.services;

import com.api.kkn.app.dto.KknDto;
import com.api.kkn.app.entity.CalonKkn;
import com.api.kkn.app.mapper.KknMapper;
import com.api.kkn.app.repository.KknRepository;
import com.api.kkn.app.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KknService implements KknInterface{
    private final KknRepository knRepository;
    @Override
    public ResponseEntity<ResponseApi> createData(KknDto kknDto) {
        CalonKkn calonKkn= KknMapper.toCalonKkn(kknDto);
        knRepository.save(calonKkn);
        return new ResponseEntity<>(new ResponseApi("success",true), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<DataResponse> showData(Integer pagenumber, Integer pagesize) {
        Pageable pageable= PageRequest.of(pagenumber,pagesize, Sort.by(Sort.Direction.DESC,"id"));
        Page<CalonKkn> page= knRepository.findAll(pageable);
        List<KknResponse> list=new ArrayList<>();
        for(CalonKkn calonkkn:page){
            KknResponse kknResponse=new KknResponse();
            kknResponse.setId(calonkkn.getId());
            kknResponse.setKode_calon_kkn(calonkkn.getKodeCalonKkn());
            MahasiswaResponse mahasiswaResponse=new MahasiswaResponse();
            mahasiswaResponse.setId_mhs(calonkkn.getIdMhs().getIdMhs());
            mahasiswaResponse.setNim_mhs(calonkkn.getIdMhs().getNimMhs());
            mahasiswaResponse.setNama_mhs(calonkkn.getIdMhs().getNamaMhs());
            mahasiswaResponse.setEmail_mhs(calonkkn.getIdMhs().getEmailMhs());
            mahasiswaResponse.setNomor_hp_mhs(calonkkn.getIdMhs().getNomorHpMhs());
            mahasiswaResponse.setTempat_lahir_mhs(calonkkn.getIdMhs().getTempatLahirMhs());
            mahasiswaResponse.setTgl_lahir_mhs(calonkkn.getIdMhs().getTglLahirMhs());
            mahasiswaResponse.setAngkatan_mhs(calonkkn.getIdMhs().getAngkatanMhs());

            PeriodeKknResponse periodeKknResponse=new PeriodeKknResponse();
            periodeKknResponse.setId_periode_kkn(calonkkn.getIdPeriodKkn().getIdPeriodeKkn());
            periodeKknResponse.setTahun_akademik(calonkkn.getIdPeriodKkn().getTahunAkademik());
            periodeKknResponse.setAngkatan(calonkkn.getIdPeriodKkn().getAngkatan());
            kknResponse.setPeriode(periodeKknResponse);
            kknResponse.setMahasiswa(mahasiswaResponse);
            kknResponse.setDesa(calonkkn.getNamaDesa());
            kknResponse.setKecamatan(calonkkn.getNamaKecamatan());
            kknResponse.setKabupaten(calonkkn.getNamaKabupaten());
            kknResponse.setStatus(calonkkn.getStatus());
            kknResponse.setGroup(calonkkn.getStatusGroup());
            kknResponse.setCreated_at(calonkkn.getCreatedAt());
            kknResponse.setUpdated_at(calonkkn.getUpdatedAt());
            list.add(kknResponse);
        }
        return new ResponseEntity<>(new DataResponse("success",true,list), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseApi> deleteData(Integer id) {
        if(!knRepository.existsById(id)){
            return new ResponseEntity<>(new ResponseApi("data tidak ditemukan",false),HttpStatus.NOT_FOUND);
        }
        knRepository.deleteById(id);
        return new ResponseEntity<>(new ResponseApi("success",true), HttpStatus.OK);
    }
}
