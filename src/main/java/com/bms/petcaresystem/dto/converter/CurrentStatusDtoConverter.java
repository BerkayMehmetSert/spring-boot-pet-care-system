package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.CurrentStatusDto;
import com.bms.petcaresystem.model.CurrentStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrentStatusDtoConverter {
    public CurrentStatusDto convert(CurrentStatus from){
        return new CurrentStatusDto(
                from.getId(),
                from.getNotes(),
                from.getInsertTime(),
                from.getPetCase() != null ? from.getPetCase().getId() : null,
                from.getStatus() != null ? from.getStatus().getId() : null
        );
    }

    public List<CurrentStatusDto> convert(List<CurrentStatus> from){
        return from.stream().map(this::convert).toList();
    }
}
