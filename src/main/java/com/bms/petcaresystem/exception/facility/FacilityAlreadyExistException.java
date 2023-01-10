package com.bms.petcaresystem.exception.facility;

public class FacilityAlreadyExistException extends RuntimeException{
    public FacilityAlreadyExistException(String message) {
        super(message);
    }
}
