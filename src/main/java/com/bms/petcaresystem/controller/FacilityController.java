package com.bms.petcaresystem.controller;

import com.bms.petcaresystem.dto.FacilityDto;
import com.bms.petcaresystem.helper.message.ControllerLogMessage;
import com.bms.petcaresystem.request.address.UpdateAddressRequest;
import com.bms.petcaresystem.request.facility.CreateFacilityRequest;
import com.bms.petcaresystem.request.facility.UpdateFacilityRequest;
import com.bms.petcaresystem.service.FacilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/facility")
@Slf4j
public class FacilityController {
    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @PostMapping
    public ResponseEntity<Void> createFacility(@RequestBody CreateFacilityRequest request) {
        facilityService.createFacility(request);

        log.info(ControllerLogMessage.Facility.FACILITY_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFacility(@PathVariable String id,
                                               @RequestBody UpdateFacilityRequest request) {
        facilityService.updateFacility(id, request);

        log.info(ControllerLogMessage.Facility.FACILITY_UPDATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/address")
    public ResponseEntity<Void> updateAddressInFacility(@PathVariable String id,
                                                        @RequestBody UpdateAddressRequest request) {
        facilityService.updateAddressInFacility(id, request);

        log.info(ControllerLogMessage.Facility.FACILITY_UPDATED);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacility(@PathVariable String id) {
        facilityService.deleteFacility(id);

        log.info(ControllerLogMessage.Facility.FACILITY_DELETED);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacilityDto> findFacilityById(@PathVariable String id) {
        FacilityDto facilityDto = facilityService.findFacilityById(id);

        log.info(ControllerLogMessage.Facility.FACILITY_FOUND);
        return ResponseEntity.ok(facilityDto);
    }

    @GetMapping
    public ResponseEntity<List<FacilityDto>> findAllFacilities() {
        List<FacilityDto> facilityDtoList = facilityService.findAllFacilities();

        log.info(ControllerLogMessage.Facility.FACILITY_LISTED);
        return ResponseEntity.ok(facilityDtoList);
    }
}
