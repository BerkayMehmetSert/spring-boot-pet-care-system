package com.bms.petcaresystem.controller;

import com.bms.petcaresystem.dto.UnitDto;
import com.bms.petcaresystem.helper.message.ControllerLogMessage;
import com.bms.petcaresystem.request.unit.CreateUnitRequest;
import com.bms.petcaresystem.request.unit.UpdateUnitRequest;
import com.bms.petcaresystem.service.UnitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/unit")
@Slf4j
public class UnitController {
    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @PostMapping
    public ResponseEntity<Void> createUnit(@RequestBody CreateUnitRequest request) {
        unitService.createUnit(request);

        log.info(ControllerLogMessage.Unit.UNIT_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateInit(@PathVariable String id,
                                           @RequestBody UpdateUnitRequest request) {
        unitService.updateUnit(id, request);

        log.info(ControllerLogMessage.Unit.UNIT_UPDATED);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable String id) {
        unitService.deleteUnit(id);

        log.info(ControllerLogMessage.Unit.UNIT_DELETED);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitDto> findUnitById(@PathVariable String id) {
        UnitDto unitDto = unitService.findUnitById(id);

        log.info(ControllerLogMessage.Unit.UNIT_FOUND);
        return ResponseEntity.ok(unitDto);
    }

    @GetMapping
    public ResponseEntity<List<UnitDto>> findAllUnit() {
        List<UnitDto> unitDtoList = unitService.findAllUnits();

        log.info(ControllerLogMessage.Unit.UNIT_LISTED);
        return ResponseEntity.ok(unitDtoList);
    }
}
