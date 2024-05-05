package com.api.kkn.app.controllers;


import com.api.kkn.app.dto.PeriodeKknDto;
import com.api.kkn.app.events.LogPublisher;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.ResponseApi;
import com.api.kkn.app.services.PeriodeKknService;
import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/periodekkn")
@RequiredArgsConstructor
public class PeriodeKknController {

    private final PeriodeKknService periodeKknService;
    private final LogPublisher logPublisher;
    @GetMapping("/{pageNumber}/{pageSize}")
    ResponseEntity<DataResponse> getData(@PathVariable("pageNumber") Integer pageNumber,@PathVariable("pageSize") Integer pageSize)
    {
        logPublisher.publishLogEvent("Lihat data periode kkn via API");

        return periodeKknService.get_data(pageNumber,pageSize);
    }

    @PostMapping
    ResponseEntity<ResponseApi> insertData(@Valid @RequestBody PeriodeKknDto periodeKknDto){
        logPublisher.publishLogEvent("Insert data periode kkn via API");
        return periodeKknService.insert_data(periodeKknDto);
    }
    @PutMapping("/{id}")
    ResponseEntity<ResponseApi> updateData(@PathVariable("id") Integer id,@Valid @RequestBody PeriodeKknDto periodeKknDto){
        logPublisher.publishLogEvent("Update data periode kkn via API");
        return periodeKknService.update_data(id,periodeKknDto);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseApi> deleteData(@PathVariable("id") Integer id){
        logPublisher.publishLogEvent("Hapus data periode kkn via API");
        return periodeKknService.delete_data(id);
    }

}
