package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetServiceDto;
import com.bms.petcaresystem.model.PetService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PetServiceDtoConverter {
    private final PetProviderDtoConverter petProviderDtoConverter;
    private final PetServicePetServiceProviderDtoConverter petServicePetServiceProviderDtoConverter;
    private final PetServicePetServicePlanDtoConverter petServicePetServicePlanDtoConverter;
    private final PetServiceSpeciesDtoConverter petServiceSpeciesDtoConverter;

    public PetServiceDtoConverter(PetProviderDtoConverter petProviderDtoConverter,
                                  PetServicePetServiceProviderDtoConverter petServicePetServiceProviderDtoConverter,
                                  PetServicePetServicePlanDtoConverter petServicePetServicePlanDtoConverter,
                                  PetServiceSpeciesDtoConverter petServiceSpeciesDtoConverter) {
        this.petProviderDtoConverter = petProviderDtoConverter;
        this.petServicePetServiceProviderDtoConverter = petServicePetServiceProviderDtoConverter;
        this.petServicePetServicePlanDtoConverter = petServicePetServicePlanDtoConverter;
        this.petServiceSpeciesDtoConverter = petServiceSpeciesDtoConverter;
    }

    public PetServiceDto convert(PetService from) {
        return new PetServiceDto(
                from.getId(),
                from.getName(),
                from.getHasLimit(),
                from.getCostPerUnit(),
                from.getProviders() == null ? null : petProviderDtoConverter.convert(from.getProviders()),
                from.getPetServiceProviders() == null ? null : petServicePetServiceProviderDtoConverter.convert(from.getPetServiceProviders()),
                from.getPetServicePlans() == null ? null : petServicePetServicePlanDtoConverter.convert(from.getPetServicePlans()),
                from.getUnit() == null ? null : from.getUnit().getId(),
                from.getSpecies() == null ? null : petServiceSpeciesDtoConverter.convert(from.getSpecies())
        );
    }

    public Set<PetServiceDto> convert(Set<PetService> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }

    public List<PetServiceDto> convert(List<PetService> from) {
        return from.stream().map(this::convert).toList();
    }
}

