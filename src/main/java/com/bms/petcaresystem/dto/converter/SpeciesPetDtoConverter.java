package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.SpeciesPetDto;
import com.bms.petcaresystem.model.Pet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpeciesPetDtoConverter {
    public SpeciesPetDto convert(Pet from) {
        return new SpeciesPetDto(
                from.getId(),
                from.getName(),
                from.getBirthDate(),
                from.getNotes()
        );
    }

    public List<SpeciesPetDto> convert(List<Pet> from) {
        return from.stream().map(this::convert).toList();
    }
}
