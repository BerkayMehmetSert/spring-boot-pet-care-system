package com.bms.petcaresystem.dto;

public record PetOwnerDto(
        String id,
        String firstName,
        String lastName,
        String phone,
        String email,
        String notes
) {
}
