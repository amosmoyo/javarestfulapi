package com.cromocoder.javamvctwo.exceptions;

import com.cromocoder.javamvctwo.model.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({NotFoundException.class})
    public final ResponseEntity<Object> notFoundException(NotFoundException notFoundException){
        ExceptionModel exceptionModel = new ExceptionModel(
                notFoundException.getMessage(),
                notFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return  new ResponseEntity<>(exceptionModel, HttpStatus.NOT_FOUND);
    }
}
