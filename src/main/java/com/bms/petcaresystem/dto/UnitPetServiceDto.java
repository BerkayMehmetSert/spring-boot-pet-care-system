package com.bms.petcaresystem.dto;

public record UnitPetServiceDto(
        String id,
        String name,
        Boolean hasLimit,
        Double costPerUnit
) {
}
