package com.bms.petcaresystem.request.petserviceplan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasePetServicePlanRequest {
    private LocalDateTime plannedStartTime;
    private LocalDateTime plannedEndTime;
    private Integer plannedUnits;
    private Double costPerUnit;
    private String notes;
    private String petServiceId;
    private String petCaseId;
}
