package com.example.demo.controllers;

import com.example.demo.exceptions.TechNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TechControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TechNullException.class)
    public ResponseEntity<Object> nullNameHandler(TechNullException ex) {

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("message", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
