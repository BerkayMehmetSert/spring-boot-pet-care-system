package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetCasePetServiceProviderDto;
import com.bms.petcaresystem.model.PetServiceProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetCasePetServiceProviderDtoConverter {
    public PetCasePetServiceProviderDto convert(PetServiceProvider from) {
        return new PetCasePetServiceProviderDto(
                from.getId(),
                from.getStartTime(),
                from.getEndTime(),
                from.getUnits(),
                from.getCostPerUnit(),
                from.getPriceCharge(),
                from.getNotes(),
                from.getPetService() != null ? from.getPetService().getId() : null
        );
    }

    public List<PetCasePetServiceProviderDto> convert(List<PetServiceProvider> from) {
        return from.stream().map(this::convert).toList();
    }
}
