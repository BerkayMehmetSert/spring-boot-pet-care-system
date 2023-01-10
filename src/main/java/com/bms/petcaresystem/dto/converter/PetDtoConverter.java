package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetDto;
import com.bms.petcaresystem.model.Pet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PetDtoConverter {
    private final PetOwnerDtoConverter ownerDtoConverter;
    private final PetPetCaseDtoConverter petCaseDtoConverter;

    public PetDtoConverter(PetOwnerDtoConverter ownerDtoConverter,
                           PetPetCaseDtoConverter petCaseDtoConverter) {
        this.ownerDtoConverter = ownerDtoConverter;
        this.petCaseDtoConverter = petCaseDtoConverter;
    }

    public PetDto convert(Pet from) {
        return new PetDto(
                from.getId(),
                from.getName(),
                from.getBirthDate(),
                from.getNotes(),
                from.getSpecies() != null ? from.getSpecies().getId() : null,
                from.getOwners() != null ? ownerDtoConverter.convert(from.getOwners()) : null,
                from.getPetCases() != null ? petCaseDtoConverter.convert(from.getPetCases()) : null
        );
    }

    public Set<PetDto> convert(Set<Pet> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }

    public List<PetDto> convert(List<Pet> from) {
        return from.stream().map(this::convert).toList();
    }
}
