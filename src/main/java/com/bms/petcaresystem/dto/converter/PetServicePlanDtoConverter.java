package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetServicePlanDto;
import com.bms.petcaresystem.model.PetServicePlan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetServicePlanDtoConverter {
    public PetServicePlanDto convert(PetServicePlan from) {
        return new PetServicePlanDto(
                from.getId(),
                from.getPlannedStartTime(),
                from.getPlannedEndTime(),
                from.getPlannedUnits(),
                from.getPlannedPrice(),
                from.getCostPerUnit(),
                from.getNotes(),
                from.getPetService() == null ? null : from.getPetService().getId(),
                from.getPetCase() == null ? null : from.getPetCase().getId()
        );
    }

    public List<PetServicePlanDto> convert(List<PetServicePlan> from) {
        return from.stream().map(this::convert).toList();
    }
}
