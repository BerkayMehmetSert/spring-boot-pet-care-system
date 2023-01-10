package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetProviderDto;
import com.bms.petcaresystem.model.Provider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetProviderDtoConverter {
    public PetProviderDto convert(Provider from) {
        return new PetProviderDto(
                from.getId(),
                from.getServiceLimit(),
                from.getCurrentlyUsed(),
                from.getFacility() != null ? from.getFacility().getId() : null
        );
    }

    public List<PetProviderDto> convert(List<Provider> from) {
        return from.stream().map(this::convert).toList();
    }
}
