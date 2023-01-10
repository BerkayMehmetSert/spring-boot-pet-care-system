package com.bms.petcaresystem.exception.note;

public class NoteListEmptyException extends RuntimeException{
    public NoteListEmptyException(String message) {
        super(message);
    }
}
