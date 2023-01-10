package com.bms.petcaresystem.dto;

import java.time.LocalDate;

public record OwnerPetDto(
        String id,
        String name,
        LocalDate birthDate,
        String notes,
        String speciesId
) {
}
