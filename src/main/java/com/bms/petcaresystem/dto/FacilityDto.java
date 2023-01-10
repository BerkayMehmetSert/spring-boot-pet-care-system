package com.bms.petcaresystem.dto;

import java.util.List;

public record FacilityDto(
        String id,
        String name,
        String phone,
        String email,
        String contactPerson,
        List<FacilityPetCaseDto> petCases,
        List<FacilityProviderDto> providers,
        AddressDto address

) {
}
