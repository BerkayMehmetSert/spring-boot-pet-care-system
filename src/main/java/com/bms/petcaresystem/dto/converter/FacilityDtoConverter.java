package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.FacilityDto;
import com.bms.petcaresystem.model.Facility;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacilityDtoConverter {
    private final FacilityProviderDtoConverter facilityProviderDtoConverter;
    private final FacilityPetCaseDtoConverter facilityPetCaseDtoConverter;
    private final AddressDtoConverter addressDtoConverter;

    public FacilityDtoConverter(FacilityProviderDtoConverter facilityProviderDtoConverter,
                                FacilityPetCaseDtoConverter facilityPetCaseDtoConverter,
                                AddressDtoConverter addressDtoConverter) {
        this.facilityProviderDtoConverter = facilityProviderDtoConverter;
        this.facilityPetCaseDtoConverter = facilityPetCaseDtoConverter;
        this.addressDtoConverter = addressDtoConverter;
    }

    public FacilityDto convert(Facility from) {
        return new FacilityDto(
                from.getId(),
                from.getName(),
                from.getPhone(),
                from.getEmail(),
                from.getContactPerson(),
                from.getPetCases() != null ? facilityPetCaseDtoConverter.convert(from.getPetCases()) : null,
                from.getProviders() != null ? facilityProviderDtoConverter.convert(from.getProviders()) : null,
                from.getAddress() != null ? addressDtoConverter.convert(from.getAddress()) : null
        );
    }

    public List<FacilityDto> convert(List<Facility> from) {
        return from.stream().map(this::convert).toList();
    }
}
