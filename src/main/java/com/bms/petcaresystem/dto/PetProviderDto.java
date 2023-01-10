package com.bms.petcaresystem.dto;

import com.bms.petcaresystem.model.PetServiceProvider;

/**
 * A DTO for the {@link PetServiceProvider} entity
 */
public record PetProviderDto(
        String id,
        Integer serviceLimit,
        Integer currentlyUsed,
        String facilityId
) {
}