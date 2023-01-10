package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.OwnerDto;
import com.bms.petcaresystem.model.Owner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OwnerDtoConverter {
    private final OwnerPetDtoConverter ownerPetDtoConverter;

    public OwnerDtoConverter(OwnerPetDtoConverter ownerPetDtoConverter) {
        this.ownerPetDtoConverter = ownerPetDtoConverter;
    }

    public OwnerDto convert(Owner from) {
        return new OwnerDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getPhone(),
                from.getEmail(),
                from.getNotes(),
                from.getPets() != null ? ownerPetDtoConverter.convert(from.getPets()) : null
        );
    }

    public Set<OwnerDto> convert(Set<Owner> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }

    public List<OwnerDto> convert(List<Owner> from) {
        return from.stream().map(this::convert).toList();
    }
}
