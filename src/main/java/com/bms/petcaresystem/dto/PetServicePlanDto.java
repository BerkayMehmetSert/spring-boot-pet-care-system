package com.bms.petcaresystem.dto;

import com.bms.petcaresystem.model.PetServicePlan;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link PetServicePlan} entity
 */
public record PetServicePlanDto(
        String id,
        LocalDateTime plannedStartTime,
        LocalDateTime plannedEndTime,
        Integer plannedUnits,
        Double plannedPrice,
        Double costPerUnit,
        String notes,
        String petServiceId,
        String petCaseId
) {
}