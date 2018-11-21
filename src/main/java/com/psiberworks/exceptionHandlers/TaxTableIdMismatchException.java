package com.psiberworks.exceptionHandlers;


public class TaxTableIdMismatchException extends RuntimeException {

    public TaxTableIdMismatchException() {
        super();
    }
    public TaxTableIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
    // ...
}