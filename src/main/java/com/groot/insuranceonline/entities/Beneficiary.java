package com.groot.insuranceonline.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Beneficiary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer BenefId;
    private Integer cin;
    private String firstName;
    private String lastName;
    private String profession;
    private Float salary;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiary")
    private Set<Insurance> insurances;


}
