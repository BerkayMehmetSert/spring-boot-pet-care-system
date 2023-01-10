package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.UnitDto;
import com.bms.petcaresystem.model.Unit;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UnitDtoConverter {
    private final UnitPetServiceDtoConverter unitPetServiceDtoConverter;

    public UnitDtoConverter(UnitPetServiceDtoConverter unitPetServiceDtoConverter) {
        this.unitPetServiceDtoConverter = unitPetServiceDtoConverter;
    }

    public UnitDto convert(Unit from) {
        return new UnitDto(
                from.getId(),
                from.getName(),
                from.getPetServices() != null ? unitPetServiceDtoConverter.convert(from.getPetServices()) : null
        );
    }

    public List<UnitDto> convert(List<Unit> from) {
        return from.stream().map(this::convert).toList();
    }
}
