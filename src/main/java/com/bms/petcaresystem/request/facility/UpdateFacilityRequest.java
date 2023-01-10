package com.bms.petcaresystem.request.facility;

import com.bms.petcaresystem.request.address.UpdateAddressRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFacilityRequest extends BaseFacilityRequest {
    private UpdateAddressRequest address;
}
