package com.bms.petcaresystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
public class Species {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;

    @OneToMany(mappedBy = "species")
    private List<Pet> pets;

    @ManyToMany(mappedBy = "species")
    private Set<PetService> petServices = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Species species = (Species) o;
        return Objects.equals(id, species.id) && Objects.equals(name, species.name) && Objects.equals(pets, species.pets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pets);
    }
}
