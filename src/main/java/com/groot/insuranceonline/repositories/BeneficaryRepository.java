package com.groot.insuranceonline.repositories;

import com.groot.insuranceonline.entities.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeneficaryRepository extends JpaRepository<Beneficiary,Integer> {
    Beneficiary findByCin(int cinBf);
}
