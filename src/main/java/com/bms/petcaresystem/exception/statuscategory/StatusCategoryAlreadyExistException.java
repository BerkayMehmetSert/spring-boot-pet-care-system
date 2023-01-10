package com.bms.petcaresystem.exception.statuscategory;

public class StatusCategoryAlreadyExistException extends RuntimeException{
    public StatusCategoryAlreadyExistException(String message) {
        super(message);
    }
}
