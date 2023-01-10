package com.bms.petcaresystem.exception.owner;

public class OwnerListEmptyException extends RuntimeException{
    public OwnerListEmptyException(String message) {
        super(message);
    }
}
