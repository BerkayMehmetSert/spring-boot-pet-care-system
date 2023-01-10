package com.bms.petcaresystem.exception.petserviceprovider;

public class PetServiceProviderNotFoundException extends RuntimeException{
    public PetServiceProviderNotFoundException(String message) {
        super(message);
    }
}
