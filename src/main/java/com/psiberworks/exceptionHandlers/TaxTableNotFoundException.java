package com.psiberworks.exceptionHandlers;


public class TaxTableNotFoundException extends RuntimeException {

    public TaxTableNotFoundException() {
        super();
    }
    public TaxTableNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}