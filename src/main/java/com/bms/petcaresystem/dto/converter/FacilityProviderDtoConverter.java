package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.FacilityProviderDto;
import com.bms.petcaresystem.model.Provider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacilityProviderDtoConverter {
    public FacilityProviderDto convert(Provider from) {
        return new FacilityProviderDto(
                from.getId(),
                from.getServiceLimit(),
                from.getCurrentlyUsed(),
                from.getPetService() != null ? from.getPetService().getId() : null
        );
    }

    public List<FacilityProviderDto> convert(List<Provider> from) {
        return from.stream().map(this::convert).toList();
    }
}
