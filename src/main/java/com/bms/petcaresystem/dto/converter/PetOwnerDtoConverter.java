package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetOwnerDto;
import com.bms.petcaresystem.model.Owner;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PetOwnerDtoConverter {
    public PetOwnerDto convert(Owner from) {
        return new PetOwnerDto(
                from.getId(),
                from.getFirstName(),
                from.getLastName(),
                from.getPhone(),
                from.getEmail(),
                from.getNotes()
        );
    }

    public Set<PetOwnerDto> convert(Set<Owner> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
