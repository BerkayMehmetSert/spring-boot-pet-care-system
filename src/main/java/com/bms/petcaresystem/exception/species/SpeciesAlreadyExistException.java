package com.bms.petcaresystem.exception.species;

public class SpeciesAlreadyExistException extends RuntimeException{
    public SpeciesAlreadyExistException(String message) {
        super(message);
    }
}
