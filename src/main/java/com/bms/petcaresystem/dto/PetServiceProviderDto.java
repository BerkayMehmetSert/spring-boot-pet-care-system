package com.bms.petcaresystem.dto;

import java.time.LocalDateTime;

public record PetServiceProviderDto(
        String id,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer units,
        Double costPerUnit,
        Double priceCharge,
        String notes,
        String petServiceId,
        String petCaseId
) {
}
