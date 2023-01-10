package com.bms.petcaresystem.controller;

import com.bms.petcaresystem.dto.StatusDto;
import com.bms.petcaresystem.helper.message.ControllerLogMessage;
import com.bms.petcaresystem.request.status.CreateStatusRequest;
import com.bms.petcaresystem.request.status.UpdateStatusRequest;
import com.bms.petcaresystem.service.StatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/status")
@Slf4j
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping
    public ResponseEntity<Void> createStatus(@RequestBody CreateStatusRequest request){
        statusService.createStatus(request);

        log.info(ControllerLogMessage.Status.STATUS_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable String id,
                                             @RequestBody UpdateStatusRequest request){
        statusService.updateStatus(id, request);

        log.info(ControllerLogMessage.Status.STATUS_UPDATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/category/{categoryId}")
    public ResponseEntity<Void> updateStatusCategoryInStatus(@PathVariable String id,
                                                             @PathVariable String categoryId){
        statusService.updateStatusCategoryInStatus(id, categoryId);

        log.info(ControllerLogMessage.Status.STATUS_UPDATED);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable String id){
        statusService.deleteStatus(id);

        log.info(ControllerLogMessage.Status.STATUS_DELETED);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDto> findStatusById(@PathVariable String id){
        StatusDto statusDto = statusService.findStatusById(id);

        log.info(ControllerLogMessage.Status.STATUS_FOUND);
        return ResponseEntity.ok(statusDto);
    }

    @GetMapping
    public ResponseEntity<List<StatusDto>> findAllStatus(){
        List<StatusDto> statusDtoList = statusService.findAllStatus();

        log.info(ControllerLogMessage.Status.STATUS_LISTED);
        return ResponseEntity.ok(statusDtoList);
    }
}
