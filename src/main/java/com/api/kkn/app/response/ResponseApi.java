package com.api.kkn.app.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseApi {
    private String message;
    private Boolean success;
}
