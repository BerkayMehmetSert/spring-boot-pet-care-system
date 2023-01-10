package com.bms.petcaresystem.controller;

import com.bms.petcaresystem.dto.StatusCategoryDto;
import com.bms.petcaresystem.helper.message.ControllerLogMessage;
import com.bms.petcaresystem.request.statuscategory.CreateStatusCategoryRequest;
import com.bms.petcaresystem.request.statuscategory.UpdateStatusCategoryRequest;
import com.bms.petcaresystem.service.StatusCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/status-category")
@Slf4j
public class StatusCategoryController {
    private final StatusCategoryService statusCategoryService;

    public StatusCategoryController(StatusCategoryService statusCategoryService) {
        this.statusCategoryService = statusCategoryService;
    }

    @PostMapping
    public ResponseEntity<Void> createStatusCategory(@RequestBody CreateStatusCategoryRequest request) {
        statusCategoryService.createStatusCategory(request);

        log.info(ControllerLogMessage.StatusCategory.STATUS_CATEGORY_CREATED);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStatusCategory(@PathVariable String id,
                                                     @RequestBody UpdateStatusCategoryRequest request) {
        statusCategoryService.updateStatusCategory(id, request);

        log.info(ControllerLogMessage.StatusCategory.STATUS_CATEGORY_UPDATED);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatusCategory(@PathVariable String id) {
        statusCategoryService.deleteStatusCategory(id);

        log.info(ControllerLogMessage.StatusCategory.STATUS_CATEGORY_DELETED);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusCategoryDto> findStatusCategoryById(@PathVariable String id) {
        StatusCategoryDto statusCategoryDto = statusCategoryService.findStatusCategoryById(id);

        log.info(ControllerLogMessage.StatusCategory.STATUS_CATEGORY_FOUND);
        return ResponseEntity.ok(statusCategoryDto);
    }

    @GetMapping
    public ResponseEntity<List<StatusCategoryDto>> findAllStatusCategory() {
        List<StatusCategoryDto> statusCategoryDtoList = statusCategoryService.findAllStatusCategories();

        log.info(ControllerLogMessage.StatusCategory.STATUS_CATEGORY_LISTED);
        return ResponseEntity.ok(statusCategoryDtoList);
    }
}
