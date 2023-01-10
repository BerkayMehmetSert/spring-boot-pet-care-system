package com.bms.petcaresystem.dto;

import java.util.List;

public record StatusDto(
        String id,
        String name,
        Boolean isActive,
        String statusCategoryId,
        List<StatusCurrentStatusDto> currentStatuses
) {
}
