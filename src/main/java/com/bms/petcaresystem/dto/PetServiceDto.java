package com.bms.petcaresystem.dto;

import java.util.List;
import java.util.Set;

public record PetServiceDto(
        String id,
        String name,
        Boolean hasLimit,
        Double costPerUnit,
        List<PetProviderDto> providers,
        List<PetServicePetServiceProviderDto> petServiceProviders,
        List<PetServicePetServicePlanDto> petServicePlans,
        String unitId,
        Set<PetServiceSpeciesDto> species
) {
}
