package com.mg.apidemo.exceptions;

public record UserNotFoundResponseEntity(Integer statusCode, String message, String path) {
}
