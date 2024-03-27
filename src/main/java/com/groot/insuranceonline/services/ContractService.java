package com.groot.insuranceonline.services;

import com.groot.insuranceonline.entities.Contract;

public interface ContractService {
    Contract addContrat(Contract c);
    Contract getOldestContractBeneficairy(int idBf);

    Contract getByMatricule(String matricule);
}
