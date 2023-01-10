package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.UnitPetServiceDto;
import com.bms.petcaresystem.model.PetService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UnitPetServiceDtoConverter {
    public UnitPetServiceDto convert(PetService from) {
        return new UnitPetServiceDto(
                from.getId(),
                from.getName(),
                from.getHasLimit(),
                from.getCostPerUnit()
        );
    }

    public List<UnitPetServiceDto> convert(List<PetService> from) {
        return from.stream().map(this::convert).toList();
    }
}
