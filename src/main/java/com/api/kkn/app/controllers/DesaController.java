package com.api.kkn.app.controllers;

import com.api.kkn.app.dto.DesaDto;
import com.api.kkn.app.dto.DplDto;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.ResponseApi;
import com.api.kkn.app.services.DesaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/desa")
@RequiredArgsConstructor
public class DesaController {
    private final DesaService desaService;
    @GetMapping("/{a}/{b}")
    public ResponseEntity<DataResponse> getData(@PathVariable("a") Integer a, @PathVariable("b") Integer b){
        return desaService.showDesa(a,b);
    }
    @PostMapping
    public ResponseEntity<ResponseApi> addData(@Valid @RequestBody DesaDto desaDto) {
        return desaService.createDesa(desaDto);
    }
    @PutMapping("/{a}")
    public ResponseEntity<ResponseApi> updateData(@Valid @RequestBody DesaDto desaDto,@PathVariable("a") Integer id) {
        return desaService.updateDesa(desaDto,id);
    }
    @DeleteMapping("/{a}")
    public ResponseEntity<ResponseApi> deleteData(@PathVariable("a") Integer id) {
        return desaService.deleteDesa(id);
    }
}
