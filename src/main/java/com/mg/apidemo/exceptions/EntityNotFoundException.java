package com.mg.apidemo.exceptions;

public class EntityNotFoundException extends Exception {

    private String message;

    public EntityNotFoundException(String message) {
        super(message);
    }
}