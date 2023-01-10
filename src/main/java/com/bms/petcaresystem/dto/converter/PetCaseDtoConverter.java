package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetCaseDto;
import com.bms.petcaresystem.model.PetCase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetCaseDtoConverter {
    private final PetCaseCurrentlyStatusDtoConverter currentlyStatusDtoConverter;
    private final PetCaseNoteDtoConverter noteDtoConverter;
    private final PetCasePetServiceProviderDtoConverter petServiceProviderDtoConverter;
    private final PetCasePetServicePlanDtoConvert petServicePlanDtoConvert;
    private final PetCaseInvoiceDtoConverter invoiceDtoConverter;

    public PetCaseDtoConverter(PetCaseCurrentlyStatusDtoConverter currentlyStatusDtoConverter,
                               PetCaseNoteDtoConverter noteDtoConverter,
                               PetCasePetServiceProviderDtoConverter petServiceProviderDtoConverter,
                               PetCasePetServicePlanDtoConvert petServicePlanDtoConvert,
                               PetCaseInvoiceDtoConverter invoiceDtoConverter) {
        this.currentlyStatusDtoConverter = currentlyStatusDtoConverter;
        this.noteDtoConverter = noteDtoConverter;
        this.petServiceProviderDtoConverter = petServiceProviderDtoConverter;
        this.petServicePlanDtoConvert = petServicePlanDtoConvert;
        this.invoiceDtoConverter = invoiceDtoConverter;
    }

    public PetCaseDto convert(PetCase from) {
        return new PetCaseDto(
                from.getId(),
                from.getStartTime(),
                from.getEndTime(),
                from.getIsActive(),
                from.getFacility() != null ? from.getFacility().getId() : null,
                from.getCurrentStatuses() != null ? currentlyStatusDtoConverter.convert(from.getCurrentStatuses()) : null,
                from.getNotes() != null ? noteDtoConverter.convert(from.getNotes()) : null,
                from.getPetServiceProviders() != null ? petServiceProviderDtoConverter.convert(from.getPetServiceProviders()) : null,
                from.getPetServicePlans() != null ? petServicePlanDtoConvert.convert(from.getPetServicePlans()) : null,
                from.getInvoices() != null ? invoiceDtoConverter.convert(from.getInvoices()) : null
        );
    }

    public List<PetCaseDto> convert(List<PetCase> from) {
        return from.stream().map(this::convert).toList();
    }
}
