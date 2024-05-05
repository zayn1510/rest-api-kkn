package com.api.kkn.app.controllers;


import com.api.kkn.app.dto.MahasiswaDto;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.ResponseApi;
import com.api.kkn.app.services.MahasiswaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/mahasiswa")
@RequiredArgsConstructor
public class MahasiswaController {
    private final MahasiswaService mahasiswaService;


    @GetMapping("/{a}/{b}")
    public ResponseEntity<DataResponse> show(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        return mahasiswaService.getMahasiswa(a,b);
    }
    @SneakyThrows
    @PostMapping
    public ResponseEntity<ResponseApi> create(@Valid @RequestParam("foto") MultipartFile foto,@ModelAttribute MahasiswaDto mahasiswa) {
        return mahasiswaService.insertMahasiswa(mahasiswa, foto);
    }

    @SneakyThrows
    @PostMapping("/update")
    public ResponseEntity<ResponseApi> update(@Valid @RequestParam("foto") MultipartFile foto,@ModelAttribute MahasiswaDto mahasiswaDto) {
        return mahasiswaService.updateMahasiswa(mahasiswaDto,foto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseApi> delete(@PathVariable("id") Integer id){
        return mahasiswaService.deleteMahasiswa(id);
    }

}
