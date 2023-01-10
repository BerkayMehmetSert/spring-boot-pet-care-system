package com.bms.petcaresystem.exception.petservice;

public class PetServiceNotFoundException extends RuntimeException{
    public PetServiceNotFoundException(String message) {
        super(message);
    }
}
