package com.example.ourdiary.exception;

import java.io.IOException;

public class FileCannotTransferToException extends IOException {
    public FileCannotTransferToException(String message) {
        super(message);
    }
}
