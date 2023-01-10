package com.bms.petcaresystem.request.petservice;

import com.bms.petcaresystem.request.species.CreateSpeciesRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreatePetServiceRequest extends BasePetServiceRequest{
    private Set<CreateSpeciesRequest> species;
}
