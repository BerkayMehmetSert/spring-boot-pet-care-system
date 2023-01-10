package com.bms.petcaresystem.request.provider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseProviderRequest {
    private Integer serviceLimit;
    private Integer currentlyUsed;
    private String facilityId;
    private String petServiceId;
}
