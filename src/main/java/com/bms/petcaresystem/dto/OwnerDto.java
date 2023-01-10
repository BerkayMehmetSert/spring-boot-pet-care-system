package com.bms.petcaresystem.dto;

import java.util.Set;

public record OwnerDto(
        String id,
        String firstName,
        String lastName,
        String phone,
        String email,
        String notes,
        Set<OwnerPetDto> pets
) {
}
