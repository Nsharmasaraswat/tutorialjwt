package com.example.Tutorial.Application.exception;

public class DuplicateEntityException extends RuntimeException {

    public DuplicateEntityException(String objectName) {
        super(objectName + " " + "already Present");
    }
}
