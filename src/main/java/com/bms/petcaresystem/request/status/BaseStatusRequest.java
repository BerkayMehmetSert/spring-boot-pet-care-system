package com.bms.petcaresystem.request.status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseStatusRequest {
    private String name;
    private String statusCategoryId;
}
