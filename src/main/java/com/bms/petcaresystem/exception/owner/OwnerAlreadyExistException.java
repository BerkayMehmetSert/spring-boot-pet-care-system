package com.bms.petcaresystem.exception.owner;

public class OwnerAlreadyExistException extends RuntimeException{
    public OwnerAlreadyExistException(String message) {
        super(message);
    }
}
