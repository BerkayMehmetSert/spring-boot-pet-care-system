package com.bms.petcaresystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Facility {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;

    @Column(length = 64)
    private String phone;

    private String email;

    private String contactPerson;

    @OneToMany(mappedBy = "facility")
    private List<PetCase> petCases;

    @OneToMany(mappedBy = "facility")
    private List<Provider> providers;

    @OneToOne(mappedBy = "facility",cascade = CascadeType.ALL)
    private Address address;
}
