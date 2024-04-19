package com.example.celesca.bookserver.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) { super(message); }
}
