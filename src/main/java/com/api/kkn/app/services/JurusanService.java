package com.api.kkn.app.services;

import com.api.kkn.app.dto.JurusanDto;
import com.api.kkn.app.entity.Fakultas;
import com.api.kkn.app.entity.Jurusan;
import com.api.kkn.app.repository.JurusanRepository;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.FakultasResponse;
import com.api.kkn.app.response.JurusanResponse;
import com.api.kkn.app.response.ResponseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JurusanService implements JurusanInterface {
    private final JurusanRepository jurusanRepository;
    private static final  String CACHE_NAME="jurusan";
    private static final Integer PAGE_OVER=100;

    @CacheEvict(value = CACHE_NAME, allEntries = true)
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
    @CacheEvict(value =CACHE_NAME, allEntries = true)
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

    @CacheEvict(value = CACHE_NAME, allEntries = true)
    @Override
    public ResponseEntity<ResponseApi> delete_data(Integer id) {
        // check first data exist or not
        if(jurusanRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(new ResponseApi("data not found",false),HttpStatus.NOT_FOUND);
        }
        jurusanRepository.deleteById(id);
        return new ResponseEntity<>(new ResponseApi("success",true),HttpStatus.OK);
    }



    @Cacheable(value = CACHE_NAME,key = "'alljurusan'")
    @Override
    public ResponseEntity<DataResponse> get_data(Integer pageNumber, Integer pageSize) {
        List<JurusanResponse> list=(pageSize > PAGE_OVER)
                ? loadFromDatabase(pageNumber, pageSize)
                : loadFromCache(pageNumber, pageSize);
        return new ResponseEntity<>(new DataResponse("success", true, list), HttpStatus.OK);
    }
    @Override
    public List<JurusanResponse> loadFromDatabase(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, "idJurusan"));
        Page<Jurusan> data = jurusanRepository.findAllWithFakultas(pageable);
        return data.stream()
                .map(jurusan -> {
                    Fakultas fakultas = jurusan.getFakultas();
                    FakultasResponse fakultasResponse = new FakultasResponse(
                            fakultas.getIdFakultas(),
                            fakultas.getKodeFakultas(),
                            fakultas.getNamaFakultas()
                    );
                    return new JurusanResponse(
                            jurusan.getIdJurusan(),
                            jurusan.getKodeJurusan(),
                            jurusan.getNamaJurusan(),
                            fakultasResponse
                    );
                })
                .toList();
    }

    @Override
    public List<JurusanResponse> loadFromCache(Integer pageNumber, Integer pageSize) {
        return loadFromDatabase(pageNumber,pageSize);
    }
}
