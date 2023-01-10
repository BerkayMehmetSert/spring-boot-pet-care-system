package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.StatusCategoryDto;
import com.bms.petcaresystem.model.StatusCategory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatusCategoryDtoConverter {
    private final StatusCategoryStatusDtoConverter statusCategoryStatusDtoConverter;

    public StatusCategoryDtoConverter(StatusCategoryStatusDtoConverter statusCategoryStatusDtoConverter) {
        this.statusCategoryStatusDtoConverter = statusCategoryStatusDtoConverter;
    }

    public StatusCategoryDto convert(StatusCategory from) {
        return new StatusCategoryDto(
                from.getId(),
                from.getName(),
                from.getStatuses() != null ? statusCategoryStatusDtoConverter.convert(from.getStatuses()) : null
        );
    }

    public List<StatusCategoryDto> convert(List<StatusCategory> from) {
        return from.stream().map(this::convert).toList();
    }
}
