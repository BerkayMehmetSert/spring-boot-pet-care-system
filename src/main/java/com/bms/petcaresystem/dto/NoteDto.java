package com.bms.petcaresystem.dto;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.bms.petcaresystem.model.Note} entity
 */
public record NoteDto(
        String id,
        String notes,
        LocalDateTime insertTime,
        String petCaseId
) {
}