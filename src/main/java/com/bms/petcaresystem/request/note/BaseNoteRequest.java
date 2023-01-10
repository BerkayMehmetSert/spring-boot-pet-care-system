package com.bms.petcaresystem.request.note;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseNoteRequest {
    private String notes;
    private String petCaseId;
}
