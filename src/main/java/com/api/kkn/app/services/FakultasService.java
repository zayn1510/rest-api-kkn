package com.api.kkn.app.services;

import com.api.kkn.app.dto.FakultasDto;
import com.api.kkn.app.entity.Fakultas;
import com.api.kkn.app.mapper.FakultasMapper;
import com.api.kkn.app.repository.FakultasRepository;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.FakultasResponse;
import com.api.kkn.app.response.ResponseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FakultasService implements FakultasInterface {

    private final FakultasRepository fakultasRepository;
    private static final String CACHE_NAME = "fakultas";

    @Cacheable(value = CACHE_NAME,key = "'allfakultas'")
    @Override
    public DataResponse get_data(Integer pageNumber,Integer pageSize) {
        Integer PAGE_OVER = 100;
        List<FakultasResponse> dtoList=(pageSize> PAGE_OVER)
                ? loadFromDatabase(pageNumber,pageSize) : loadFromCache(pageNumber,pageSize);
        return new DataResponse("success",true,dtoList);
    }

    public List<FakultasResponse> loadFromCache(Integer pageNumber,Integer pageSize) {
        return loadFromDatabase(pageNumber,pageSize);
    }

    @CacheEvict(value = CACHE_NAME,allEntries = true)
    @Override
    public ResponseApi insert_data(FakultasDto fakultasDto) {
        Fakultas fakultas=new Fakultas();
        fakultas.setKodeFakultas(fakultasDto.getKode_fakultas());
        fakultas.setNamaFakultas(fakultasDto.getNama_fakultas());
        fakultasRepository.save(fakultas);
        return new ResponseApi("success",true);
    }



    @CacheEvict(value =CACHE_NAME,allEntries = true)
    @Override
    public ResponseApi update_data(Integer id, FakultasDto fakultasDto) {

      if(fakultasRepository.findById(id).isEmpty()) {
          return new ResponseApi("Data not found", false);
      }
        Fakultas fakultas=fakultasRepository.findById(id).get();
        FakultasMapper.updateDtoToEntity(fakultasDto,fakultas);
        fakultasRepository.save(fakultas);
        return new ResponseApi("sucess",true);
    }

    @CacheEvict(value = CACHE_NAME,allEntries = true)
    @Override
    public ResponseApi delete_data(Integer id) {
        if(fakultasRepository.findById(id).isEmpty()){
            return new ResponseApi("data not found",false);
        }
        fakultasRepository.deleteById(id);
        return new ResponseApi("success",true);
    }

    @Cacheable(value = "fakultasbykode",key = "'bykodefakultas'")
    @Override
    public Object get_data_by_kode_fakultas(String kode) {
        List<Fakultas> data=fakultasRepository.findByKodeFakultas(kode);
        if(data.isEmpty()){
            return new ResponseApi("Data not found",true);
        }
        return new DataResponse("success",true,data);
    }

    @Override
    public List<FakultasResponse> loadFromDatabase(Integer pageNumber, Integer pageSize) {
        Pageable pageable= PageRequest.of(pageNumber,pageSize, Sort.by(Sort.Direction.DESC,"idFakultas"));
        Page<Fakultas> data=fakultasRepository.findAll(pageable);
        return data.stream().map(
                fakultas -> new FakultasResponse(fakultas.getIdFakultas(),fakultas.getKodeFakultas(),fakultas.getNamaFakultas())
        ).toList();
    }
}
