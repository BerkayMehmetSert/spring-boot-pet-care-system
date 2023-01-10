package com.bms.petcaresystem.exception.pet;

public class PetListEmptyException extends RuntimeException{
    public PetListEmptyException(String message) {
        super(message);
    }
}
