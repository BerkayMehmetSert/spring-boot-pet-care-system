package com.bms.petcaresystem.dto;

import java.time.LocalDateTime;

public record PetCaseCurrentlyStatusDto(
        String id,
        String notes,
        LocalDateTime insertTime,
        String statusId
) {
}
