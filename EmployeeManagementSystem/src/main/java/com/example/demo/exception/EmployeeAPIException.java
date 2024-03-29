package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class EmployeeAPIException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public EmployeeAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public EmployeeAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
