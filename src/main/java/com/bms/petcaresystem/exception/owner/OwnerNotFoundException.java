package com.bms.petcaresystem.exception.owner;

public class OwnerNotFoundException extends RuntimeException{
    public OwnerNotFoundException(String message) {
        super(message);
    }
}
