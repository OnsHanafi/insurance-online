package com.groot.insuranceonline.services;

import com.groot.insuranceonline.entities.Beneficiary;

import java.util.List;

public interface BeneficaryService {
    Beneficiary addBF(Beneficiary bf);

    List<Beneficiary> getAllBenefecaries();

    Beneficiary getBfByCin(int cinBf);
}
