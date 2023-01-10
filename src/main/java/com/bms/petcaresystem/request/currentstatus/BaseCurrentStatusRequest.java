package com.bms.petcaresystem.request.currentstatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseCurrentStatusRequest {
    private String notes;
    private String petCaseId;
    private String statusId;
}
