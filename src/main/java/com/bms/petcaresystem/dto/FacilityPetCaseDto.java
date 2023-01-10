package com.bms.petcaresystem.dto;

import java.time.LocalDateTime;

public record FacilityPetCaseDto(
        String id,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Boolean isActive,
        String petId
) {
}
