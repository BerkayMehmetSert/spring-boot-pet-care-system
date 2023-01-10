package com.bms.petcaresystem.service;

import com.bms.petcaresystem.dto.NoteDto;
import com.bms.petcaresystem.dto.converter.NoteDtoConverter;
import com.bms.petcaresystem.exception.note.NoteListEmptyException;
import com.bms.petcaresystem.exception.note.NoteNotFoundException;
import com.bms.petcaresystem.helper.DateHelper;
import com.bms.petcaresystem.helper.message.BusinessLogMessage;
import com.bms.petcaresystem.helper.message.BusinessMessage;
import com.bms.petcaresystem.model.Note;
import com.bms.petcaresystem.repository.NoteRepository;
import com.bms.petcaresystem.request.note.CreateNoteRequest;
import com.bms.petcaresystem.request.note.UpdateNoteRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class NoteService {
    private final NoteRepository noteRepository;
    private final PetCaseService petCaseService;
    private final NoteDtoConverter converter;

    public NoteService(NoteRepository noteRepository,
                       PetCaseService petCaseService,
                       NoteDtoConverter converter) {
        this.noteRepository = noteRepository;
        this.petCaseService = petCaseService;
        this.converter = converter;
    }

    public void createNote(final CreateNoteRequest request) {
        Note note = new Note();

        note.setInsertTime(DateHelper.getCurrentDateTime());
        note.setNotes(request.getNotes());
        note.setPetCase(petCaseService.findPetCaseByPetCaseId(request.getPetCaseId()));

        noteRepository.save(note);
        log.info(BusinessLogMessage.Note.NOTE_CREATED);
    }

    public void updateNote(final String id, final UpdateNoteRequest request) {
        Note note = findNoteByNoteId(id);

        note.setNotes(request.getNotes());
        note.setPetCase(petCaseService.findPetCaseByPetCaseId(request.getPetCaseId()));

        noteRepository.save(note);
        log.info(BusinessLogMessage.Note.NOTE_UPDATED);
    }

    public void deleteNote(final String id) {
        Note note = findNoteByNoteId(id);

        noteRepository.delete(note);
        log.info(BusinessLogMessage.Note.NOTE_DELETED);
    }

    public List<NoteDto> findAllNotes() {
        List<Note> notes = noteRepository.findAll();

        if (notes.isEmpty()) {
            log.error(BusinessLogMessage.Note.NOTE_LIST_EMPTY);
            throw new NoteListEmptyException(BusinessMessage.Note.NOTE_LIST_EMPTY);
        }

        log.info(BusinessLogMessage.Note.NOTE_LIST);
        return converter.convert(notes);
    }

    protected Note findNoteByNoteId(final String id) {
        return noteRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Note.NOTE_NOT_FOUND);
            throw new NoteNotFoundException(BusinessMessage.Note.NOTE_NOT_FOUND);
        });
    }
}
