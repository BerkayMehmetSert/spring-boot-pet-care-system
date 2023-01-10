package com.bms.petcaresystem.request.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseAddressRequest {
    private String street;

    private String city;

    private String state;

    private String zipCode;
}
