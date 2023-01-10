package com.bms.petcaresystem.dto;

import java.time.LocalDateTime;

public record PetPetCaseDto(
        String id,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Boolean isActive,
        String facilityId
) {
}
