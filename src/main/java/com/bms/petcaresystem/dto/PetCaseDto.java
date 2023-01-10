package com.bms.petcaresystem.dto;

import java.time.LocalDateTime;
import java.util.List;

public record PetCaseDto(
        String id,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Boolean isActive,
        String facilityId,
        List<PetCaseCurrentlyStatusDto> currentlyStatuses,
        List<PetCaseNoteDto> notes,
        List<PetCasePetServiceProviderDto> petServiceProviders,
        List<PetCasePetServicePlanDto> petServicePlans,
        List<PetCaseInvoiceDto> invoices
) {
}
