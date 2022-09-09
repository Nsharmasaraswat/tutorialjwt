package com.example.Tutorial.Application.exception;

import lombok.extern.slf4j.XSlf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionalHandler {

    @ExceptionHandler(DuplicateEntityException.class)
    ResponseEntity alreadyExistsException(DuplicateEntityException dx) {
        System.out.println("log: handling exception" + dx);
        return new ResponseEntity(HttpStatus.CONFLICT);
    }

}
