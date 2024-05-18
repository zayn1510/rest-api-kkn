package com.api.kkn.app.services;

import com.api.kkn.app.dto.MahasiswaDto;
import com.api.kkn.app.entity.Mahasiswa;
import com.api.kkn.app.mapper.MahasiswaMapper;
import com.api.kkn.app.repository.MahasiswaRepository;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.JurusanResponse;
import com.api.kkn.app.response.MahasiswaResponse;
import com.api.kkn.app.response.ResponseApi;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MahasiswaService implements MahasiswaInterface {

    private final MahasiswaRepository mahasiswaRepository;
    private final static String CACHE_NAME="mahasiswa";
    private final static String KEY_NAME="'allmahasiswa'";

    @CacheEvict(value =CACHE_NAME,allEntries = true)
    @SneakyThrows
    @Override
    public ResponseEntity<ResponseApi> insertMahasiswa(MahasiswaDto mahasiswaDto, MultipartFile foto) {


        String filename=null;
        // check its real image
        if (!foto.isEmpty()) {
            if (ImageIO.read(foto.getInputStream()) == null) {
                return new ResponseEntity<>(new ResponseApi("the file is not image",false),HttpStatus.OK);
            }
            filename=uploadTheFile(foto);
        }


        if(mahasiswaRepository.findByNimMhs(mahasiswaDto.getNimMhs()) !=null) {
            return new ResponseEntity<>(new ResponseApi("Nim ini sudah ada",true), HttpStatus.OK);
        }
        mahasiswaDto.setFotoMhs(filename);
        Mahasiswa mahaiswa= MahasiswaMapper.modelToDto(mahasiswaDto);
        mahasiswaRepository.save(mahaiswa);
        return new ResponseEntity<>(new ResponseApi("success",true), HttpStatus.OK);
    }

    @CacheEvict(value = CACHE_NAME,allEntries = true)
    @SneakyThrows
    @Override
    public ResponseEntity<ResponseApi> updateMahasiswa(MahasiswaDto mahasiswaDto, MultipartFile foto) {
        if(mahasiswaRepository.findByNimMhs(mahasiswaDto.getNimMhs()) ==null){
            return new ResponseEntity<>(new ResponseApi("nim tidak ditemukan",false),HttpStatus.OK);
        }
        String filename=null;
        // check its real image
        if (!foto.isEmpty()) {
            if (ImageIO.read(foto.getInputStream()) == null) {
                return new ResponseEntity<>(new ResponseApi("the file is not image",false),HttpStatus.OK);
            }
            filename=uploadTheFile(foto);
        }

        mahasiswaDto.setFotoMhs(filename);
        Mahasiswa update=mahasiswaRepository.findByNimMhs(mahasiswaDto.getNimMhs());
        MahasiswaMapper.updateModel(mahasiswaDto,update);
        mahasiswaRepository.save(update);
        return new ResponseEntity<>(new ResponseApi("success",true), HttpStatus.OK);
    }

    @CacheEvict(value = CACHE_NAME,allEntries = true)
    @Override
    public ResponseEntity<ResponseApi> deleteMahasiswa(Integer id) {
        if(mahasiswaRepository.findById(id).isEmpty()){
            return new ResponseEntity<>(new ResponseApi("data tidak ditemukan",false),HttpStatus.OK);
        }
        mahasiswaRepository.deleteById(id);
        return new ResponseEntity<>(new ResponseApi("success",true), HttpStatus.OK);
    }

    @Cacheable(value = CACHE_NAME,key = KEY_NAME)
    @Override
    public ResponseEntity<DataResponse> getMahasiswa(Integer pagenumber,Integer pagesize) {
        Integer PAGE_OVER=100;
        List<MahasiswaResponse> list=(pagesize>PAGE_OVER)
                ? loadDataFromDatabase(pagenumber,pagesize)
                : loadDataFromCache(pagenumber,pagesize);
        return new ResponseEntity<>(new DataResponse("success",true,list),HttpStatus.OK);
    }

    @Override
    public List<MahasiswaResponse> loadDataFromDatabase(Integer pagenumber, Integer pagesize) {
        Pageable pageable=PageRequest.of(pagenumber,pagesize, Sort.by("idMhs").descending());
        Page<Mahasiswa> data=mahasiswaRepository.findAllWithJurusan(pageable);
        return data.stream()
                .map(mahasiswa -> {
                    MahasiswaResponse mahasiswaResponse = new MahasiswaResponse();
                    mahasiswaResponse.setId_mhs(mahasiswa.getIdMhs());
                    mahasiswaResponse.setNim_mhs(mahasiswa.getNimMhs());
                    mahasiswaResponse.setNama_mhs(mahasiswa.getNamaMhs());
                    mahasiswaResponse.setEmail_mhs(mahasiswa.getEmailMhs());
                    mahasiswaResponse.setAngkatan_mhs(mahasiswa.getAngkatanMhs());
                    mahasiswaResponse.setNomor_hp_mhs(mahasiswa.getNomorHpMhs());
                    mahasiswaResponse.setTempat_lahir_mhs(mahasiswa.getTempatLahirMhs());
                    mahasiswaResponse.setTgl_lahir_mhs(mahasiswa.getTglLahirMhs());

                    JurusanResponse jurusanResponse = new JurusanResponse();
                    jurusanResponse.setId_jurusan(mahasiswa.getJurusan().getIdJurusan());
                    jurusanResponse.setKode_jurusan(mahasiswa.getJurusan().getKodeJurusan());
                    jurusanResponse.setNama_jurusan(mahasiswa.getJurusan().getNamaJurusan());

                    mahasiswaResponse.setJurusan(jurusanResponse);
                    return mahasiswaResponse;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<MahasiswaResponse> loadDataFromCache(Integer pagenumber, Integer pagesize) {
        return List.of();
    }

    @SneakyThrows
    private String uploadTheFile(MultipartFile foto) {
        // Create directory if it doesn't exist
        String UPLOAD_FOLDER = "./uploads/";
        File uploadDir = new File(UPLOAD_FOLDER);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        // Save the file to the specified folder
        LocalDateTime currentDateTime = LocalDateTime.now();
        String extension = Objects.requireNonNull(foto.getContentType()).split("/")[1];
        String fileName=currentDateTime+"."+extension;
        Path path = Paths.get(UPLOAD_FOLDER + File.separator + fileName);
        Files.copy(foto.getInputStream(), path);
        return fileName;
    }
}
