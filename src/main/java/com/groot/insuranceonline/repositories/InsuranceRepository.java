package com.groot.insuranceonline.repositories;

import com.groot.insuranceonline.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Integer> {
    List<Insurance> findInsuranceByBeneficiaryId(int idBf);
}
