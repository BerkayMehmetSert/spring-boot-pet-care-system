package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.StatusCategoryStatusDto;
import com.bms.petcaresystem.model.Status;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatusCategoryStatusDtoConverter {
    public StatusCategoryStatusDto convert(Status from) {
        return new StatusCategoryStatusDto(
                from.getId(),
                from.getName(),
                from.getIsActive()
        );
    }

    public List<StatusCategoryStatusDto> convert(List<Status> from) {
        return from.stream().map(this::convert).toList();
    }
}
