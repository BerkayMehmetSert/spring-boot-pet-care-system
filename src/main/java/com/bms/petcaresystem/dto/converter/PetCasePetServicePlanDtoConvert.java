package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetCasePetServicePlanDto;
import com.bms.petcaresystem.model.PetServicePlan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetCasePetServicePlanDtoConvert {
    public PetCasePetServicePlanDto convert(PetServicePlan from) {
        return new PetCasePetServicePlanDto(
                from.getId(),
                from.getPlannedStartTime(),
                from.getPlannedEndTime(),
                from.getPlannedUnits(),
                from.getPlannedPrice(),
                from.getCostPerUnit(),
                from.getNotes(),
                from.getPetService() != null ? from.getPetService().getId() : null
        );
    }

    public List<PetCasePetServicePlanDto> convert(List<PetServicePlan> from) {
        return from.stream().map(this::convert).toList();
    }
}
