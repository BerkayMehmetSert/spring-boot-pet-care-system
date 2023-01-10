package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetServiceProviderDto;
import com.bms.petcaresystem.model.PetServiceProvider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetServiceProviderDtoConverter {
    public PetServiceProviderDto convert(PetServiceProvider from) {
        return new PetServiceProviderDto(
                from.getId(),
                from.getStartTime(),
                from.getEndTime(),
                from.getUnits(),
                from.getCostPerUnit(),
                from.getPriceCharge(),
                from.getNotes(),
                from.getPetService() != null ? from.getPetService().getId() : null,
                from.getPetCase() != null ? from.getPetCase().getId() : null
        );
    }

    public List<PetServiceProviderDto> convert(List<PetServiceProvider> from) {
        return from.stream().map(this::convert).toList();
    }
}
