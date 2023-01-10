package com.bms.petcaresystem.request.petserviceprovider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasePetServiceProviderRequest {
    private Integer units;
    private Double costPerUnit;
    private String notes;
    private String  petServiceId;
    private String petCaseId;
}
