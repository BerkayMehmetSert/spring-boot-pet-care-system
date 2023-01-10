package com.bms.petcaresystem.dto;

import java.time.LocalDateTime;

public record StatusCurrentStatusDto(
        String id,
        String notes,
        LocalDateTime insertTime,
        String petCaseId
) {
}
