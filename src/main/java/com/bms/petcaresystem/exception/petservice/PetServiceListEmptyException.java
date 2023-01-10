package com.bms.petcaresystem.exception.petservice;

public class PetServiceListEmptyException extends RuntimeException{
    public PetServiceListEmptyException(String message) {
        super(message);
    }
}
