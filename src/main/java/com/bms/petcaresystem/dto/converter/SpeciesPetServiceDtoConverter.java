package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.SpeciesPetServiceDto;
import com.bms.petcaresystem.model.PetService;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;
@Component
public class SpeciesPetServiceDtoConverter {
    public SpeciesPetServiceDto convert(PetService from) {
        return new SpeciesPetServiceDto(
                from.getId(),
                from.getName(),
                from.getHasLimit(),
                from.getCostPerUnit(),
                from.getUnit() != null ? from.getUnit().getId() : null
        );
    }

    public Set<SpeciesPetServiceDto> convert(Set<PetService> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
