package com.bms.petcaresystem.dto;

/**
 * A DTO for the {@link com.bms.petcaresystem.model.Provider} entity
 */
public record ProviderDto(
        String id,
        Integer serviceLimit,
        Integer currentlyUsed,
        String facilityId,
        String petServiceId
) {
}