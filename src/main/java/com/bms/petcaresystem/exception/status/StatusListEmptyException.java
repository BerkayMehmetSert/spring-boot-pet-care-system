package com.bms.petcaresystem.exception.status;

public class StatusListEmptyException extends RuntimeException{
    public StatusListEmptyException(String message) {
        super(message);
    }
}
