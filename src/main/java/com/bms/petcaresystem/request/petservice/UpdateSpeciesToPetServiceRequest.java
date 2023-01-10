package com.bms.petcaresystem.request.petservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSpeciesToPetServiceRequest {
    private String currentSpeciesId;
    private String newSpeciesId;
}
