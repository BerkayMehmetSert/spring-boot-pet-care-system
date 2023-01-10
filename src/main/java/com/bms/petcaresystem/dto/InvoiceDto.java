package com.bms.petcaresystem.dto;

import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.bms.petcaresystem.model.Invoice} entity
 */
public record InvoiceDto(
        String id,
        String invoiceCode,
        LocalDateTime createdTime,
        Double invoiceAmount,
        Double discount,
        Double timeCharge,
        Double amountCharge,
        String notes,
        String petCaseId
) {
}