package com.bms.petcaresystem.controller;

import com.bms.petcaresystem.dto.OwnerDto;
import com.bms.petcaresystem.helper.message.ControllerLogMessage;
import com.bms.petcaresystem.request.owner.CreateOwnerRequest;
import com.bms.petcaresystem.request.owner.UpdateOwnerRequest;
import com.bms.petcaresystem.service.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owner")
@Slf4j
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public ResponseEntity<Void> createOwner(@RequestBody CreateOwnerRequest request) {
        ownerService.createOwner(request);

        log.info(ControllerLogMessage.Owner.OWNER_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOwner(@PathVariable String id, @RequestBody UpdateOwnerRequest request) {
        ownerService.updateOwner(id, request);

        log.info(ControllerLogMessage.Owner.OWNER_UPDATED);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable String id) {
        ownerService.deleteOwner(id);

        log.info(ControllerLogMessage.Owner.OWNER_DELETED);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDto> findOwnerById(@PathVariable String id) {
        OwnerDto ownerDto = ownerService.findOwnerById(id);

        log.info(ControllerLogMessage.Owner.OWNER_FOUND);
        return ResponseEntity.ok(ownerDto);
    }

    @GetMapping
    public ResponseEntity<List<OwnerDto>> findAllOwners() {
        List<OwnerDto> ownerDtoList = ownerService.findAllOwners();

        log.info(ControllerLogMessage.Owner.OWNER_LISTED);
        return ResponseEntity.ok(ownerDtoList);
    }
}
