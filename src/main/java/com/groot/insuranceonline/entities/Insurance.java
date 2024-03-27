package com.groot.insuranceonline.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Insurance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer insuranceId;
    private String designation;
    private Float price;

    @JsonIgnore
    @ManyToOne
    private Beneficiary beneficiary;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Contract contract;

}
