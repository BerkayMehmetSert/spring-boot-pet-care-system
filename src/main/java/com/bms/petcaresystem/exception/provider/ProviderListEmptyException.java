package com.bms.petcaresystem.exception.provider;

public class ProviderListEmptyException extends RuntimeException{
    public ProviderListEmptyException(String message) {
        super(message);
    }
}
