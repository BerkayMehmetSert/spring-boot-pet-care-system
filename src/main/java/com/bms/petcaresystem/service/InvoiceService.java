package com.bms.petcaresystem.service;

import com.bms.petcaresystem.dto.InvoiceDto;
import com.bms.petcaresystem.dto.converter.InvoiceDtoConverter;
import com.bms.petcaresystem.exception.invoice.InvoiceNotFoundException;
import com.bms.petcaresystem.helper.DateHelper;
import com.bms.petcaresystem.helper.Generator;
import com.bms.petcaresystem.helper.message.BusinessLogMessage;
import com.bms.petcaresystem.helper.message.BusinessMessage;
import com.bms.petcaresystem.model.Invoice;
import com.bms.petcaresystem.model.PetCase;
import com.bms.petcaresystem.model.PetServiceProvider;
import com.bms.petcaresystem.repository.InvoiceRepository;
import com.bms.petcaresystem.request.invoice.CreateInvoiceRequest;
import com.bms.petcaresystem.request.invoice.UpdateInvoiceRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final PetCaseService petCaseService;
    private final InvoiceDtoConverter converter;

    public InvoiceService(InvoiceRepository invoiceRepository,
                          PetCaseService petCaseService,
                          InvoiceDtoConverter converter) {
        this.invoiceRepository = invoiceRepository;
        this.petCaseService = petCaseService;
        this.converter = converter;
    }

    public void createInvoice(final CreateInvoiceRequest request) {
        Invoice invoice = new Invoice();

        invoice.setInvoiceCode(Generator.generateInvoiceCode());
        invoice.setCreatedTime(DateHelper.getCurrentDateTime());
        invoice.setDiscount(request.getDiscount());
        invoice.setTimeCharge(request.getTimeCharge());
        invoice.setAmountCharge(request.getAmountCharge());
        invoice.setNotes(request.getNotes());
        invoice.setPetCase(petCaseService.findPetCaseByPetCaseId(request.getPetCaseId()));
        invoice.setInvoiceAmount(calculateInvoiceAmount(invoice));

        invoiceRepository.save(invoice);
        log.info(BusinessLogMessage.Invoice.INVOICE_CREATED);
    }

    public void updateInvoice(final String id, final UpdateInvoiceRequest request) {
        Invoice invoice = findInvoiceByInvoiceId(id);

        invoice.setDiscount(request.getDiscount());
        invoice.setTimeCharge(request.getTimeCharge());
        invoice.setAmountCharge(request.getAmountCharge());
        invoice.setNotes(request.getNotes());
        invoice.setPetCase(petCaseService.findPetCaseByPetCaseId(request.getPetCaseId()));
        invoice.setInvoiceAmount(calculateInvoiceAmount(invoice));

        invoiceRepository.save(invoice);
        log.info(BusinessLogMessage.Invoice.INVOICE_UPDATED);
    }

    public InvoiceDto findInvoiceById(final String id) {
        Invoice invoice = findInvoiceByInvoiceId(id);

        log.info(BusinessLogMessage.Invoice.INVOICE_FIND);
        return converter.convert(invoice);
    }

    private Invoice findInvoiceByInvoiceId(final String id) {
        return invoiceRepository.findById(id).orElseThrow(() -> {
            log.error(BusinessLogMessage.Invoice.INVOICE_NOT_FOUND);
            throw new InvoiceNotFoundException(BusinessMessage.Invoice.INVOICE_NOT_FOUND);
        });
    }

    private Double calculateInvoiceAmount(final Invoice invoice) {
        Double total = 0.0;
        List<Double> prices = invoice.getPetCase().getPetServiceProviders().stream()
                .map(PetServiceProvider::getPriceCharge)
                .toList();

        List<Integer> timeCharges = invoice.getPetCase().getPetServiceProviders().stream()
                .map(petServiceProvider ->
                        petServiceProvider.getEndTime().getHour() - petServiceProvider.getStartTime().getHour())
                .toList();

        for (Double price : prices) {
            total += price;
        }

        if (invoice.getAmountCharge() != null) {
            for (Double price : prices) {
                total += price * invoice.getAmountCharge();
            }
        }

        if (invoice.getDiscount() != null) {
            total -= invoice.getDiscount();

        }

        if (invoice.getTimeCharge() != null) {
            for (int i = 0; i < prices.size(); i++) {
                total += timeCharges.get(i) * invoice.getTimeCharge();
            }
        }

        if (total <= 0) {
            total = 0.0;
        }

        return total;
    }
}
