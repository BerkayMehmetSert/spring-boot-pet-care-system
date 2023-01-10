package com.bms.petcaresystem.exception.petcase;

public class PetCaseListEmptyException extends RuntimeException{
    public PetCaseListEmptyException(String message) {
        super(message);
    }
}
