package com.java.laba;

public class PersonNotFoundedException extends Exception{

    public PersonNotFoundedException() {
    }

    public PersonNotFoundedException(String message) {
        super(message);
    }

    public PersonNotFoundedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonNotFoundedException(Throwable cause) {
        super(cause);
    }

    public PersonNotFoundedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
