package com.bms.petcaresystem.dto;

import java.util.List;

public record UnitDto(
        String id,
        String name,
        List<UnitPetServiceDto> petServices
) {
}
