package com.bms.petcaresystem.dto;

import java.time.LocalDateTime;

public record PetServicePetServicePlanDto(
        String id,
        LocalDateTime plannedStartTime,
        LocalDateTime plannedEndTime,
        Integer plannedUnits,
        Double plannedPrice,
        Double costPerUnit,
        String notes,
        String petCaseId
) {
}
