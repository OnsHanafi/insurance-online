package com.groot.insuranceonline.repositories;

import com.groot.insuranceonline.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Integer> {
    Contract findByMatricule(String matricule);
}
