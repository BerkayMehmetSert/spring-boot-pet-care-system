package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetCaseCurrentlyStatusDto;
import com.bms.petcaresystem.model.CurrentStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetCaseCurrentlyStatusDtoConverter {
    public PetCaseCurrentlyStatusDto convert(CurrentStatus from) {
        return new PetCaseCurrentlyStatusDto(
                from.getId(),
                from.getNotes(),
                from.getInsertTime(),
                from.getStatus() != null ? from.getStatus().getId() : null
        );
    }

    public List<PetCaseCurrentlyStatusDto> convert(List<CurrentStatus> from) {
        return from.stream().map(this::convert).toList();
    }
}
