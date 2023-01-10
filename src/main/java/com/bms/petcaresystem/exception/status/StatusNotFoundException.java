package com.bms.petcaresystem.exception.status;

public class StatusNotFoundException extends RuntimeException{
    public StatusNotFoundException(String message) {
        super(message);
    }
}
