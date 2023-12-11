package com.example.demoapp.web.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleConstraintViolationException(ConstraintViolationException exp){
        return ResponseEntity
                    .badRequest()
                    .body( exp.getConstraintViolations()
                                .stream()
                                .map( error -> error.toString())
                                .collect(Collectors.toList()));
    }
}
