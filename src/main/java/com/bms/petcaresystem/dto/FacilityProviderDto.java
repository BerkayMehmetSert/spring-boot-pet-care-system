package com.bms.petcaresystem.dto;

public record FacilityProviderDto(
        String id,
        Integer serviceLimit,
        Integer currentlyUsed,
        String petServiceId
) {
}
