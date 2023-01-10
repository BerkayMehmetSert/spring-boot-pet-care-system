package com.bms.petcaresystem.request.invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseInvoiceRequest {
    private Double discount;
    private Double timeCharge;
    private Double amountCharge;
    private String notes;
    private String petCaseId;
}
