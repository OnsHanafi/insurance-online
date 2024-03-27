package com.groot.insuranceonline.entities;

import com.groot.insuranceonline.enums.ContractType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;
    private String matricule;
    @Temporal(TemporalType.DATE)
    private Date dateEffet;
    @Enumerated(EnumType.STRING)
    private ContractType type;


}
