package com.bms.petcaresystem.dto;


import java.time.LocalDateTime;

public record CurrentStatusDto(
        String id,
        String notes,
        LocalDateTime insertTime,
        String petCaseId,
        String statusId
){
}