package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.StatusDto;
import com.bms.petcaresystem.model.Status;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatusDtoConverter {
    private final StatusCurrentStatusDtoConverter statusCurrentStatusDtoConverter;

    public StatusDtoConverter(StatusCurrentStatusDtoConverter statusCurrentStatusDtoConverter) {
        this.statusCurrentStatusDtoConverter = statusCurrentStatusDtoConverter;
    }

    public StatusDto convert(Status from) {
        return new StatusDto(
                from.getId(),
                from.getName(),
                from.getIsActive(),
                from.getStatusCategory() != null ? from.getStatusCategory().getId() : null,
                from.getCurrentStatuses() != null ? statusCurrentStatusDtoConverter.convert(from.getCurrentStatuses()) : null
        );
    }

    public List<StatusDto> convert(List<Status> from) {
        return from.stream().map(this::convert).toList();
    }
}
