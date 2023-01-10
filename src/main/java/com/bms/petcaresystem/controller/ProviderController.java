package com.bms.petcaresystem.controller;

import com.bms.petcaresystem.dto.ProviderDto;
import com.bms.petcaresystem.helper.message.ControllerLogMessage;
import com.bms.petcaresystem.request.provider.CreateProviderRequest;
import com.bms.petcaresystem.request.provider.UpdateProviderRequest;
import com.bms.petcaresystem.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Slf4j
public class ProviderController {
    private final ProviderService providerService;

    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @PostMapping
    public ResponseEntity<Void> createProvider(@RequestBody CreateProviderRequest request) {
        providerService.createProvider(request);

        log.info(ControllerLogMessage.Provider.PROVIDER_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProvider(@PathVariable String id, @RequestBody UpdateProviderRequest request) {
        providerService.updateProvider(id, request);

        log.info(ControllerLogMessage.Provider.PROVIDER_UPDATED);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable String id) {
        providerService.deleteProvider(id);

        log.info(ControllerLogMessage.Provider.PROVIDER_DELETED);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderDto> findProviderById(@PathVariable String id) {
        ProviderDto providerDto = providerService.findProviderById(id);

        log.info(ControllerLogMessage.Provider.PROVIDER_FOUND);
        return ResponseEntity.ok(providerDto);
    }

    @GetMapping
    public ResponseEntity<List<ProviderDto>> findAllProviders() {
        List<ProviderDto> providerDtoList = providerService.findAllProviders();

        log.info(ControllerLogMessage.Provider.PROVIDER_LISTED);
        return ResponseEntity.ok(providerDtoList);
    }
}
