package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetServicePetServicePlanDto;
import com.bms.petcaresystem.model.PetServicePlan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetServicePetServicePlanDtoConverter {
    public PetServicePetServicePlanDto convert(PetServicePlan from) {
        return new PetServicePetServicePlanDto(
                from.getId(),
                from.getPlannedStartTime(),
                from.getPlannedEndTime(),
                from.getPlannedUnits(),
                from.getPlannedPrice(),
                from.getCostPerUnit(),
                from.getNotes(),
                from.getPetCase() != null ? from.getPetCase().getId() : null
        );
    }

    public List<PetServicePetServicePlanDto> convert(List<PetServicePlan> from) {
        return from.stream().map(this::convert).toList();
    }
}
