package com.groot.insuranceonline.services;

import com.groot.insuranceonline.entities.Beneficiary;
import com.groot.insuranceonline.enums.ContractType;

import java.util.List;
import java.util.Set;

public interface BeneficaryService {
    Beneficiary addBF(Beneficiary bf);

    List<Beneficiary> getAllBenefecaries();

    Beneficiary getBfByCin(int cinBf);

    Set<Beneficiary> getBeneficairesByType(ContractType tc);
}
