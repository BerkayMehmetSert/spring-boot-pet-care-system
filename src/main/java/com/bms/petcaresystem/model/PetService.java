package com.bms.petcaresystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PetService {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;

    private Boolean hasLimit;

    private Double costPerUnit;

    @OneToMany(mappedBy = "petService")
    private List<Provider> providers;

    @OneToMany(mappedBy = "petService")
    private List<PetServiceProvider> petServiceProviders;

    @OneToMany(mappedBy = "petService")
    private List<PetServicePlan> petServicePlans;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "pet_service_species",
            joinColumns = @JoinColumn(name = "pet_service_id"),
            inverseJoinColumns = @JoinColumn(name = "species_id"))
    private Set<Species> species = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetService that = (PetService) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(hasLimit, that.hasLimit) && Objects.equals(costPerUnit, that.costPerUnit) && Objects.equals(providers, that.providers) && Objects.equals(petServiceProviders, that.petServiceProviders) && Objects.equals(petServicePlans, that.petServicePlans) && Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, hasLimit, costPerUnit, providers, petServiceProviders, petServicePlans, unit);
    }
}
