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
public class PetServiceProvider {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer units;

    private Double costPerUnit;

    private Double priceCharge;

    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="pet_service_id")
    private PetService petService;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="pet_case_id")
    private PetCase petCase;
}
