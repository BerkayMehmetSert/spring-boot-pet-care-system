package com.bms.petcaresystem.dto;

public record SpeciesPetServiceDto(
        String id,
        String name,
        Boolean hasLimit,
        Double costPerUnit,
        String unitId
) {
}
