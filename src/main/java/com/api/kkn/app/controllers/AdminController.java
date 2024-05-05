package com.api.kkn.app.controllers;

import com.api.kkn.app.dto.SignInDto;
import com.api.kkn.app.response.DataResponse;
import com.api.kkn.app.response.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @GetMapping
    public String welcome()
    {
        return "Welcome to KKn App";
    }

    @PostMapping
    public ResponseEntity<DataResponse> tesLogin(@RequestBody SignInDto signInDto){
        List<SignInDto> sign=new ArrayList<>();
        sign.add(signInDto);
        return ResponseEntity.ok(new DataResponse("success",true,sign));
    }
}
