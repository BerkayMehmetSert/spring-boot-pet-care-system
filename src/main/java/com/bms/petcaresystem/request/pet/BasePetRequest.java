package com.bms.petcaresystem.request.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasePetRequest {
    private String name;
    private LocalDate birthDate;
    private String notes;
    private String speciesId;
}
