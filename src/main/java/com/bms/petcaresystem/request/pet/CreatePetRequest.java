package com.bms.petcaresystem.request.pet;

import com.bms.petcaresystem.request.owner.CreateOwnerRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CreatePetRequest extends BasePetRequest{
    private Set<CreateOwnerRequest> owners;
}
