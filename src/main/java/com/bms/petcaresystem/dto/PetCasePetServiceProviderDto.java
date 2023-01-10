package com.bms.petcaresystem.dto;

import java.time.LocalDateTime;

public record PetCasePetServiceProviderDto(
        String id,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Integer units,
        Double costPerUnit,
        Double priceCharge,
        String notes,
        String petServiceId
) {
}
