package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.StatusCurrentStatusDto;
import com.bms.petcaresystem.model.CurrentStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatusCurrentStatusDtoConverter {
    public StatusCurrentStatusDto convert(CurrentStatus from) {
        return new StatusCurrentStatusDto(
                from.getId(),
                from.getNotes(),
                from.getInsertTime(),
                from.getPetCase() != null ? from.getPetCase().getId() : null
        );
    }

    public List<StatusCurrentStatusDto> convert(List<CurrentStatus> from) {
        return from.stream().map(this::convert).toList();
    }
}
