package com.bms.petcaresystem.controller;

import com.bms.petcaresystem.dto.NoteDto;
import com.bms.petcaresystem.helper.message.ControllerLogMessage;
import com.bms.petcaresystem.request.note.CreateNoteRequest;
import com.bms.petcaresystem.request.note.UpdateNoteRequest;
import com.bms.petcaresystem.service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/note")
@Slf4j
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<Void> createNote(@RequestBody CreateNoteRequest request) {
        noteService.createNote(request);

        log.info(ControllerLogMessage.Note.NOTE_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateNote(@PathVariable String id, @RequestBody UpdateNoteRequest request) {
        noteService.updateNote(id, request);

        log.info(ControllerLogMessage.Note.NOTE_UPDATED);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable String id) {
        noteService.deleteNote(id);

        log.info(ControllerLogMessage.Note.NOTE_DELETED);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<NoteDto>> findAllNotes() {
        List<NoteDto> noteDtoList = noteService.findAllNotes();

        log.info(ControllerLogMessage.Note.NOTE_LISTED);
        return ResponseEntity.ok(noteDtoList);
    }
}
