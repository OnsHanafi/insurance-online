package com.groot.insuranceonline.repositories;

import com.groot.insuranceonline.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Integer> {
    @Query("SELECT i FROM Insurance i WHERE i.beneficiary.BenefId = :idBf")
    List<Insurance> findInsuranceByBeneficiaryBenefId(@Param("idBf")int idBf);
}
