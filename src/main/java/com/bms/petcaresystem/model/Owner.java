package com.bms.petcaresystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(length = 128)
    private String firstName;

    @Column(length = 128)
    private String lastName;

    @Column(length = 64)
    private String phone;

    private String email;

    private String notes;

    @ManyToMany(mappedBy = "owners")
    private Set<Pet> pets = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(id, owner.id) && Objects.equals(firstName, owner.firstName) && Objects.equals(lastName, owner.lastName) && Objects.equals(phone, owner.phone) && Objects.equals(email, owner.email) && Objects.equals(notes, owner.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phone, email, notes);
    }
}
