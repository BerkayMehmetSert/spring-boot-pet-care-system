package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.PetCaseInvoiceDto;
import com.bms.petcaresystem.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetCaseInvoiceDtoConverter {
    public PetCaseInvoiceDto convert(Invoice from) {
        return new PetCaseInvoiceDto(
                from.getId(),
                from.getInvoiceCode(),
                from.getCreatedTime(),
                from.getInvoiceAmount(),
                from.getDiscount(),
                from.getTimeCharge(),
                from.getAmountCharge(),
                from.getNotes()
        );
    }

    public List<PetCaseInvoiceDto> convert(List<Invoice> from) {
        return from.stream().map(this::convert).toList();
    }
}
