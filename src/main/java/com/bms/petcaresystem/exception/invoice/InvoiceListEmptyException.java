package com.bms.petcaresystem.exception.invoice;

public class InvoiceListEmptyException extends RuntimeException{
    public InvoiceListEmptyException(String message) {
        super(message);
    }
}
