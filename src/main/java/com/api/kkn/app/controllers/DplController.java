package com.api.kkn.app.controllers;

import com.api.kkn.app.dto.DplDto;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.ResponseApi;
import com.api.kkn.app.services.DplService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/dpl")
@RequiredArgsConstructor
public class DplController {

    private final DplService dplService;

    @GetMapping("/{a}/{b}")
    public ResponseEntity<DataResponse> getDpl(@PathVariable("a") Integer a,@PathVariable("b") Integer b){
        return dplService.showDpl(a,b);
    }
    @PostMapping
    public ResponseEntity<ResponseApi> addDpl(@Valid @RequestBody DplDto dto) {
        return dplService.createDpl(dto);
    }
    @PutMapping("/{a}")
    public ResponseEntity<Object> updateDpl(@Valid @RequestBody DplDto dto,@PathVariable("a") Integer id) {
        return dplService.updateDpl(dto,id);
    }
    @DeleteMapping("/{a}")
    public ResponseEntity<ResponseApi> deleteDpl(@PathVariable("a") Integer id) {
        return dplService.deleteDpl(id);
    }

}
