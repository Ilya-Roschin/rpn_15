package com.java.laba;

import java.io.IOException;

public class CustomFileException extends IOException {

    public CustomFileException() {
    }

    public CustomFileException(String message) {
        super(message);
    }

    public CustomFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomFileException(Throwable cause) {
        super(cause);
    }
}
