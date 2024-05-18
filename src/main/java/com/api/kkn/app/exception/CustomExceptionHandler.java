package com.api.kkn.app.exception;

import com.api.kkn.app.events.LogPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;


@RestControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {


    private final LogPublisher logPublisher;
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleInvalidrequest(MethodArgumentNotValidException ex){
        Map<String,Object> errormap=new HashMap<>();
        Map<String,Object> validation=new HashMap<>();
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("success",false);
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> validation.put(fieldError.getField(), fieldError.getDefaultMessage()));
        logPublisher.publishLogEvent("Exception in "+ex.getMessage());
        errormap.put("message",validation);
        return errormap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageConversionException.class)
    public Map<String, Object> handleInvalidMessageConversion(HttpMessageConversionException ex){
        Map<String,Object> errormap=new HashMap<>();
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("success",false);
        errormap.put("message",ex.getMessage());
        logPublisher.publishLogEvent("Exception in "+ex.getMessage());
        return errormap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Map<String, Object> handleInvalidRequestMethod(HttpRequestMethodNotSupportedException ex){
        Map<String,Object> errormap=new HashMap<>();
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("success",false);
        errormap.put("message",ex.getMessage());
        logPublisher.publishLogEvent("Exception in "+ex.getMessage());
        return errormap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Map<String, Object> handleValueNull(SQLIntegrityConstraintViolationException ex){
        Map<String,Object> errormap=new HashMap<>();
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("success",false);
        String errorMessage = ex.getMessage();
        if(errorMessage.contains("Duplicate entry")) {
            errormap.put("message", "Data yang Anda masukkan sudah ada.");
        } else if(errorMessage.contains("cannot be null")) {
            errormap.put("message", "ada beberapa data tidak boleh kosong.");
        } else {
            errormap.put("message", "Terjadi kesalahan validasi data. Silakan periksa kembali.");
        }
        logPublisher.publishLogEvent("Exception in "+ex.getMessage());
        return errormap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String,Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Map<String,Object> errormap=new HashMap<>();
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("status",HttpStatus.BAD_REQUEST);
        errormap.put("error","Request Body Is Missing");
        logPublisher.publishLogEvent("Exception in "+ex.getMessage());
        return errormap;
    }
}
