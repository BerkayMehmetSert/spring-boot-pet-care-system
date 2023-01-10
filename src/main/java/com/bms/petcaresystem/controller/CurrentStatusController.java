package com.bms.petcaresystem.controller;

import com.bms.petcaresystem.dto.CurrentStatusDto;
import com.bms.petcaresystem.helper.message.ControllerLogMessage;
import com.bms.petcaresystem.request.currentstatus.CreateCurrentStatusRequest;
import com.bms.petcaresystem.request.currentstatus.UpdateCurrentStatusRequest;
import com.bms.petcaresystem.service.CurrentStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/current-status")
@Slf4j
public class CurrentStatusController {
    private final CurrentStatusService currentStatusService;

    public CurrentStatusController(CurrentStatusService currentStatusService) {
        this.currentStatusService = currentStatusService;
    }

    @PostMapping
    public ResponseEntity<Void> createCurrentStatus(@RequestBody CreateCurrentStatusRequest request) {
        currentStatusService.createCurrentStatus(request);

        log.info(ControllerLogMessage.CurrentStatus.CURRENT_STATUS_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCurrentStatus(@PathVariable String id,
                                                    @RequestBody UpdateCurrentStatusRequest request) {
        currentStatusService.updateCurrentStatus(id, request);

        log.info(ControllerLogMessage.CurrentStatus.CURRENT_STATUS_UPDATED);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurrentStatus(@PathVariable String id) {
        currentStatusService.deleteCurrentStatus(id);

        log.info(ControllerLogMessage.CurrentStatus.CURRENT_STATUS_DELETED);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CurrentStatusDto> findCurrentStatusById(@PathVariable String id) {
        CurrentStatusDto currentStatusDto = currentStatusService.findCurrentStatusById(id);

        log.info(ControllerLogMessage.CurrentStatus.CURRENT_STATUS_FOUND);
        return ResponseEntity.ok(currentStatusDto);
    }

    @GetMapping
    public ResponseEntity<List<CurrentStatusDto>> findAllCurrentStatuses() {
        List<CurrentStatusDto> currentStatusDtoList = currentStatusService.findAllCurrentStatuses();

        log.info(ControllerLogMessage.CurrentStatus.CURRENT_STATUS_LISTED);
        return ResponseEntity.ok(currentStatusDtoList);
    }
}
