package com.example.ourdiary.exception;

public class FileNameNotFoundException extends RuntimeException {

    public FileNameNotFoundException(String message) {
        super(message);
    }

    public FileNameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
