package com.bms.petcaresystem.exception.status;

public class StatusAlreadyExistException extends RuntimeException{
    public StatusAlreadyExistException(String message) {
        super(message);
    }
}
