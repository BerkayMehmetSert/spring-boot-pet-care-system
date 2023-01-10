package com.bms.petcaresystem.exception.petserviceprovider;

public class PetServiceProviderListEmptyException extends RuntimeException{
    public PetServiceProviderListEmptyException(String message) {
        super(message);
    }
}
