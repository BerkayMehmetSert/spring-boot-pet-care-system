package com.bms.petcaresystem.dto;

import java.time.LocalDate;

public record SpeciesPetDto(
        String id,
        String name,
        LocalDate birthDate,
        String notes
) {
}
