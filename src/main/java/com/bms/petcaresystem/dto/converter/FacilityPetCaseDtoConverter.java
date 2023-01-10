package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.FacilityPetCaseDto;
import com.bms.petcaresystem.model.PetCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacilityPetCaseDtoConverter {
    public FacilityPetCaseDto convert(PetCase from) {
        return new FacilityPetCaseDto(
                from.getId(),
                from.getStartTime(),
                from.getEndTime(),
                from.getIsActive(),
                from.getPet() != null ? from.getPet().getId() : null
        );
    }

    public List<FacilityPetCaseDto> convert(List<PetCase> from) {
        return from.stream().map(this::convert).toList();
    }
}
