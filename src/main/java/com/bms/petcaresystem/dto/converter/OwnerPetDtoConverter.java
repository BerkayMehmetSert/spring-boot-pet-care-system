package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.OwnerPetDto;
import com.bms.petcaresystem.model.Pet;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OwnerPetDtoConverter {
    public OwnerPetDto convert(Pet from) {
        return new OwnerPetDto(
                from.getId(),
                from.getName(),
                from.getBirthDate(),
                from.getNotes(),
                from.getSpecies() != null ? from.getSpecies().getId() : null
        );
    }

    public Set<OwnerPetDto> convert(Set<Pet> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
