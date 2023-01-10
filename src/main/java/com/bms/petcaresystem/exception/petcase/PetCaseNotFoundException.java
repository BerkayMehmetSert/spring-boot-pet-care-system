package com.bms.petcaresystem.exception.petcase;

public class PetCaseNotFoundException extends RuntimeException{
    public PetCaseNotFoundException(String message) {
        super(message);
    }
}
