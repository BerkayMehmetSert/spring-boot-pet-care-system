package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.SpeciesDto;
import com.bms.petcaresystem.model.Species;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SpeciesDtoConverter {
    private final SpeciesPetDtoConverter speciesPetDtoConverter;
    private final SpeciesPetServiceDtoConverter speciesPetServiceDtoConverter;

    public SpeciesDtoConverter(SpeciesPetDtoConverter speciesPetDtoConverter,
                               SpeciesPetServiceDtoConverter speciesPetServiceDtoConverter) {
        this.speciesPetDtoConverter = speciesPetDtoConverter;
        this.speciesPetServiceDtoConverter = speciesPetServiceDtoConverter;
    }

    public SpeciesDto convert(Species from) {
        return new SpeciesDto(
                from.getId(),
                from.getName(),
                from.getPets() != null ? speciesPetDtoConverter.convert(from.getPets()) : null,
                from.getPetServices() != null ? speciesPetServiceDtoConverter.convert(from.getPetServices()) : null
        );
    }

    public Set<SpeciesDto> convert(Set<Species> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }

    public List<SpeciesDto> convert(List<Species> from) {
        return from.stream().map(this::convert).toList();
    }
}
