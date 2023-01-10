package com.bms.petcaresystem.exception.petservice;

public class PetServiceAlreadyExistException extends RuntimeException{
    public PetServiceAlreadyExistException(String message) {
        super(message);
    }
}
