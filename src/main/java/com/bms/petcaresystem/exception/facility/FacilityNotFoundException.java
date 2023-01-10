package com.bms.petcaresystem.exception.facility;

public class FacilityNotFoundException extends RuntimeException{
    public FacilityNotFoundException(String message) {
        super(message);
    }
}
