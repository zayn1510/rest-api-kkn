package com.api.kkn.app.controllers;

import com.api.kkn.app.dto.KknDto;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.ResponseApi;
import com.api.kkn.app.services.KknService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/kkn")
@RequiredArgsConstructor
public class KknController {

    private final KknService kknService;

    @GetMapping("/{a}/{b}")
    ResponseEntity<DataResponse> show(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        return kknService.showData(a,b);
    }
    @PostMapping
    ResponseEntity<ResponseApi> create(@Valid @RequestBody KknDto kknDto){
        return kknService.createData(kknDto);
    }

    @DeleteMapping("/{a}")
    ResponseEntity<ResponseApi> delete(@PathVariable("a") Integer id){
        return kknService.deleteData(id);
    }

}
