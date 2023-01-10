package com.bms.petcaresystem.request.petservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasePetServiceRequest {
    private String name;
    private Boolean hasLimit;
    private Double costPerUnit;
    private String unitId;
}
