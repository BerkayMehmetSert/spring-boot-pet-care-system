package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.NoteDto;
import com.bms.petcaresystem.model.Note;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoteDtoConverter {
    public NoteDto convert(Note from) {
        return new NoteDto(
                from.getId(),
                from.getNotes(),
                from.getInsertTime(),
                from.getPetCase() != null ? from.getPetCase().getId() : null
        );
    }

    public List<NoteDto> convert(List<Note> from) {
        return from.stream().map(this::convert).toList();
    }
}
