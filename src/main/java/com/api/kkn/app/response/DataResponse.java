package com.api.kkn.app.response;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class DataResponse {
    private String message;
    private Boolean success;
    private List<?> data;
}
