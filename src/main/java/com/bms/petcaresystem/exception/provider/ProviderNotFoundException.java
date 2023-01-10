package com.bms.petcaresystem.exception.provider;

public class ProviderNotFoundException extends RuntimeException{
    public ProviderNotFoundException(String message) {
        super(message);
    }
}
