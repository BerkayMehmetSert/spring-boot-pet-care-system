package com.bms.petcaresystem.dto;

import java.util.List;

public record StatusCategoryDto(
        String id,
        String name,
        List<StatusCategoryStatusDto> statuses
) {
}
