package com.bms.petcaresystem.dto;

import java.time.LocalDateTime;

public record PetCaseNoteDto(
        String id,
        String note,
        LocalDateTime insertTime
) {
}
