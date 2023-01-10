package com.bms.petcaresystem.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public record PetDto(
        String id,
        String name,
        LocalDate birthDate,
        String notes,
        String speciesId,
        Set<PetOwnerDto> owners,
        List<PetPetCaseDto> petCases
) {
}
