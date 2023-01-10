package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.ProviderDto;
import com.bms.petcaresystem.model.Provider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProviderDtoConverter {
    public ProviderDto convert(Provider from) {
        return new ProviderDto(
                from.getId(),
                from.getServiceLimit(),
                from.getCurrentlyUsed(),
                from.getFacility() != null ? from.getFacility().getId() : null,
                from.getPetService() != null ? from.getPetService().getId() : null
        );
    }

    public List<ProviderDto> convert(List<Provider> from) {
        return from.stream().map(this::convert).toList();
    }
}
