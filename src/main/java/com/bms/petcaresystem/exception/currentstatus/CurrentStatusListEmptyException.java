package com.bms.petcaresystem.exception.currentstatus;

public class CurrentStatusListEmptyException extends RuntimeException{
    public CurrentStatusListEmptyException(String message) {
        super(message);
    }
}
