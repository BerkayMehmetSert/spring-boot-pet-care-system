package com.bms.petcaresystem.request.petcase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasePetCaseRequest {
    private String petId;
    private String facilityId;
}
