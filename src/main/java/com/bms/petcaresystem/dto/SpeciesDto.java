package com.bms.petcaresystem.dto;

import java.util.List;
import java.util.Set;

public record SpeciesDto(
        String id,
        String name,
        List<SpeciesPetDto> pets,
        Set<SpeciesPetServiceDto> petServices
) {
}
