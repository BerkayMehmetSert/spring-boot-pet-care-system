package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetPetCaseDto;
import com.bms.petcaresystem.model.PetCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetPetCaseDtoConverter {
    public PetPetCaseDto convert(PetCase from) {
        return new PetPetCaseDto(
                from.getId(),
                from.getStartTime(),
                from.getEndTime(),
                from.getIsActive(),
                from.getFacility() != null ? from.getFacility().getId() : null
        );
    }

    public List<PetPetCaseDto> convert(List<PetCase> from) {
        return from.stream().map(this::convert).toList();
    }
}
