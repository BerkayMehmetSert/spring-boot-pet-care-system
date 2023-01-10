package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.AddressDto;
import com.bms.petcaresystem.model.Address;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressDtoConverter {
    public AddressDto convert(Address from) {
        return new AddressDto(
                from.getId(),
                from.getStreet(),
                from.getCity(),
                from.getState(),
                from.getZipCode()
        );
    }

    public List<AddressDto> convert(List<Address> from) {
        return from.stream().map(this::convert).toList();
    }
}
