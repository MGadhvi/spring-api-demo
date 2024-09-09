package com.mg.apidemo.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserNotFoundAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<UserNotFoundResponseEntity> handleEntityNotFoundException(UserNotFoundException e, HttpServletRequest request) {
        UserNotFoundResponseEntity responseEntity = new UserNotFoundResponseEntity(HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(responseEntity, HttpStatus.NOT_FOUND);
    }
}
