package com.bms.petcaresystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetServicePlan {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private LocalDateTime plannedStartTime;

    private LocalDateTime plannedEndTime;

    private Integer plannedUnits;

    private Double plannedPrice;

    private Double costPerUnit;

    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="pet_service_id")
    private PetService petService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="pet_case_id")
    private PetCase petCase;
}
