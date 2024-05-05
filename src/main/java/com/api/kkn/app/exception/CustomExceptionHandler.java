package com.api.kkn.app.exception;

import com.api.kkn.app.response.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice
public class CustomExceptionHandler {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleInvalidrequest(MethodArgumentNotValidException ex){
        Map<String,Object> errormap=new HashMap<>();
        Map<String,Object> validation=new HashMap<>();
        HttpStatus status=HttpStatus.BAD_GATEWAY;
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("success",false);
        ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
            validation.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        errormap.put("message",validation);
        return errormap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageConversionException.class)
    public Map<String, Object> handleInvalidMessageConversion(HttpMessageConversionException ex){
        Map<String,Object> errormap=new HashMap<>();
        HttpStatus status=HttpStatus.BAD_GATEWAY;
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("success",false);
        errormap.put("message",ex.getMessage());

        return errormap;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Map<String, Object> handleInvalidRequestMethod(HttpRequestMethodNotSupportedException ex){
        Map<String,Object> errormap=new HashMap<>();
        HttpStatus status=HttpStatus.BAD_GATEWAY;
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("success",false);
        errormap.put("message",ex.getMessage());
        return errormap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public Map<String, Object> handleValueNull(SQLIntegrityConstraintViolationException ex){
        Map<String,Object> errormap=new HashMap<>();
        HttpStatus status=HttpStatus.BAD_GATEWAY;
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("success",false);
        String errorMessage = ex.getMessage();
        String columnName = getColumnName(errorMessage);
        if(errorMessage.contains("Duplicate entry")) {
            errormap.put("message", "Data yang Anda masukkan sudah ada.");
        } else if(errorMessage.contains("cannot be null")) {
            errormap.put("message", "ada beberapa data tidak boleh kosong.");
        } else {
            errormap.put("message", "Terjadi kesalahan validasi data. Silakan periksa kembali.");
        }
        return errormap;
    }

    // Fungsi untuk mendapatkan nama kolom dari pesan kesalahan
    private String getColumnName(String errorMessage) {
        String columnName = "";
        Pattern pattern = Pattern.compile("`([^`]*)`"); // Pola untuk mengekstrak nama kolom dalam backticks (`)
        Matcher matcher = pattern.matcher(errorMessage);
        if (matcher.find()) {
            columnName = matcher.group(1);
        }
        return columnName;
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String,Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        Map<String,Object> errormap=new HashMap<>();
        Map<String,Object> validation=new HashMap<>();
        errormap.put("time", String.valueOf(new Date()));
        errormap.put("status",HttpStatus.BAD_REQUEST);
        errormap.put("error","Request Body Is Missing");
        return errormap;
    }
}
