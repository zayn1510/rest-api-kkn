package com.api.kkn.app.controllers;


import com.api.kkn.app.dto.FakultasDto;
import com.api.kkn.app.response.DataResponse;

import com.api.kkn.app.response.ResponseApi;
import com.api.kkn.app.services.FakultasService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fakultas")
public class FakultasController {

    private final FakultasService fakultasService;
    public FakultasController(FakultasService fakultasService) {
        this.fakultasService = fakultasService;
    }

    @GetMapping("/{pageNumber}/{pageSize}")
    ResponseEntity<DataResponse> getData(@PathVariable("pageNumber") Integer pageNumber, @PathVariable("pageSize") Integer pageSize)
    {
        return new ResponseEntity<>(fakultasService.get_data(pageNumber, pageSize), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseApi> insertData(@Valid @RequestBody  FakultasDto fakultasDto) {
        return new ResponseEntity<>(fakultasService.insert_data(fakultasDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseApi> updateData(@PathVariable("id") Integer id,@RequestBody  FakultasDto fakultasDto) {
        return new ResponseEntity<>(fakultasService.update_data(id, fakultasDto), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseApi> deleteData(@PathVariable("id") Integer id){
        return new ResponseEntity<>(fakultasService.delete_data(id), HttpStatus.OK);
    }

    @GetMapping("/search/{kode_fakultas}")
    public ResponseEntity<Object> searchDataByKode(@PathVariable("kode_fakultas") String kode){
        return new ResponseEntity<>(fakultasService.get_data_by_kode_fakultas(kode),HttpStatus.OK);
    }
}
