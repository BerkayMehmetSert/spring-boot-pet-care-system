package com.bms.petcaresystem.dto;

import java.time.LocalDateTime;

public record PetCaseInvoiceDto(
        String id,
        String invoiceCode,
        LocalDateTime createdTime,
        Double invoiceAmount,
        Double discount,
        Double timeCharge,
        Double amountCharge,
        String notes
) {
}
