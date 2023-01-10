package com.bms.petcaresystem.request.owner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseOwnerRequest {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String notes;
}
