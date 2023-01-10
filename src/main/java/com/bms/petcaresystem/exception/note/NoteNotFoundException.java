package com.bms.petcaresystem.exception.note;

public class NoteNotFoundException extends RuntimeException{
    public NoteNotFoundException(String message) {
        super(message);
    }
}
