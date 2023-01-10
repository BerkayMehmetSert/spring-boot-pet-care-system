package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetServicePetServiceProviderDto;
import com.bms.petcaresystem.model.PetServiceProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetServicePetServiceProviderDtoConverter {
    public PetServicePetServiceProviderDto convert(PetServiceProvider from) {
        return new PetServicePetServiceProviderDto(
                from.getId(),
                from.getStartTime(),
                from.getEndTime(),
                from.getUnits(),
                from.getCostPerUnit(),
                from.getPriceCharge(),
                from.getNotes(),
                from.getPetCase() != null ? from.getPetCase().getId() : null
        );
    }

    public List<PetServicePetServiceProviderDto> convert(List<PetServiceProvider> from) {
        return from.stream().map(this::convert).toList();
    }
}
