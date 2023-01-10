package com.bms.petcaresystem.dto.converter;

import com.bms.petcaresystem.dto.InvoiceDto;
import com.bms.petcaresystem.model.Invoice;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceDtoConverter {
    public InvoiceDto convert(Invoice from) {
        return new InvoiceDto(
                from.getId(),
                from.getInvoiceCode(),
                from.getCreatedTime(),
                from.getInvoiceAmount(),
                from.getDiscount(),
                from.getTimeCharge(),
                from.getAmountCharge(),
                from.getNotes(),
                from.getPetCase() != null ? from.getPetCase().getId() : null
        );
    }

    public List<InvoiceDto> convert(List<Invoice> from) {
        return from.stream().map(this::convert).toList();
    }
}
