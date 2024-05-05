package com.api.kkn.app.controllers;


import com.api.kkn.app.dto.JurusanDto;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.ResponseApi;
import com.api.kkn.app.services.JurusanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/jurusan")
public class JurusanController {

    private final JurusanService jurusanService;

    public JurusanController(JurusanService jurusanService) {
        this.jurusanService = jurusanService;
    }
    @GetMapping("/{pageNumber}/{pageSize}")
    ResponseEntity<DataResponse> get_data_jurusan(@PathVariable("pageNumber") Integer pageNumber,@PathVariable("pageSize") Integer pageSize){
        return jurusanService.get_data(pageNumber,pageSize);
    }
    @PostMapping
    ResponseEntity<ResponseApi> insert_data_jurusan(@Valid  @RequestBody JurusanDto jurusanDto){
        return jurusanService.insert_data(jurusanDto);
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseApi> update_data_jurusan(@PathVariable("id") Integer id,@Valid @RequestBody JurusanDto jurusanDto){
        return jurusanService.update_data(id,jurusanDto);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseApi> delete_data_jurusan(@PathVariable("id") Integer id){
        return jurusanService.delete_data(id);
    }
}
