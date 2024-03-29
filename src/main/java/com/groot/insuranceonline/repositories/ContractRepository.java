package com.groot.insuranceonline.repositories;

import com.groot.insuranceonline.entities.Contract;
import com.groot.insuranceonline.enums.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {
    Contract findByMatricule(String matricule);

    @Query("select i from Contract i where i.type = :type")
    Contract findByContractType(@Param("type") ContractType type);
}
