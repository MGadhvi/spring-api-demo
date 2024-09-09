package com.mg.apidemo.exceptions;

public class UserNotFoundException extends Exception {

    private String message;

    public UserNotFoundException(String message) {
        super(message);
    }
}