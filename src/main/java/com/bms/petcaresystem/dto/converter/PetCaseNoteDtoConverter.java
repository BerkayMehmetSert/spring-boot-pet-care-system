package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetCaseNoteDto;
import com.bms.petcaresystem.model.Note;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetCaseNoteDtoConverter {
    public PetCaseNoteDto convert(Note from) {
        return new PetCaseNoteDto(
                from.getId(),
                from.getNotes(),
                from.getInsertTime()
        );
    }

    public List<PetCaseNoteDto> convert(List<Note> from) {
        return from.stream().map(this::convert).toList();
    }
}
