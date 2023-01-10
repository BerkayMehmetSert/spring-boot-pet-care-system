package com.bms.petcaresystem.controller;

import com.bms.petcaresystem.dto.InvoiceDto;
import com.bms.petcaresystem.helper.message.ControllerLogMessage;
import com.bms.petcaresystem.request.invoice.CreateInvoiceRequest;
import com.bms.petcaresystem.request.invoice.UpdateInvoiceRequest;
import com.bms.petcaresystem.service.InvoiceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/invoice")
@Slf4j
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public ResponseEntity<Void> createInvoice(@RequestBody CreateInvoiceRequest request) {
        invoiceService.createInvoice(request);

        log.info(ControllerLogMessage.Invoice.INVOICE_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateInvoice(@PathVariable String id,
                                              @RequestBody UpdateInvoiceRequest request) {
        invoiceService.updateInvoice(id, request);

        log.info(ControllerLogMessage.Invoice.INVOICE_UPDATED);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDto> findInvoiceById(@PathVariable String id) {
        InvoiceDto invoiceDto = invoiceService.findInvoiceById(id);

        log.info(ControllerLogMessage.Invoice.INVOICE_FOUND);
        return ResponseEntity.ok(invoiceDto);
    }
}
