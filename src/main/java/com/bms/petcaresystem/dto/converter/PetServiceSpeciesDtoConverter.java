package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetServiceSpeciesDto;
import com.bms.petcaresystem.model.Species;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PetServiceSpeciesDtoConverter {
    public PetServiceSpeciesDto convert(Species from) {
        return new PetServiceSpeciesDto(
                from.getId(),
                from.getName()
        );
    }

    public Set<PetServiceSpeciesDto> convert(Set<Species> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
