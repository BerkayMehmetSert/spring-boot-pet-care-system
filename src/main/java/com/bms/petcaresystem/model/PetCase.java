package com.bms.petcaresystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetCase {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="facility_id")
    private Facility facility;

    @OneToMany(mappedBy = "petCase")
    private List<CurrentStatus> currentStatuses;

    @OneToMany(mappedBy = "petCase")
    private List<Note> notes;

    @OneToMany(mappedBy = "petCase")
    private List<PetServiceProvider> petServiceProviders;

    @OneToMany(mappedBy = "petCase")
    private List<PetServicePlan> petServicePlans;

    @OneToMany(mappedBy = "petCase")
    private List<Invoice> invoices;

}
