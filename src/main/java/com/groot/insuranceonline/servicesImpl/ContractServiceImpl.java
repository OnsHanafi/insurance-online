package com.groot.insuranceonline.servicesImpl;

import com.groot.insuranceonline.entities.Contract;
import com.groot.insuranceonline.entities.Insurance;
import com.groot.insuranceonline.repositories.ContractRepository;
import com.groot.insuranceonline.services.BeneficaryService;
import com.groot.insuranceonline.services.ContractService;
import com.groot.insuranceonline.services.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {


    private final ContractRepository contractRepository;
    private  final InsuranceService insuranceService;


    @Override
    public Contract addContrat(Contract c) {

        return this.contractRepository.save(c);


    }

    @Override
    public Contract getOldestContractBeneficairy(int idBf) {
        List<Insurance> insurances = this.insuranceService.getInsuranceByBenfId(idBf);

       Optional<Contract> oldestContract = insurances.stream()
                .map(Insurance::getContract)
                .filter(contract -> contract != null)
                .min(Comparator.comparing(Contract::getDateEffet));

       return oldestContract.orElse(
               Contract.builder()
                       .matricule("NOT_FOUND")
                       .build()
       ) ;
    }

    @Override
    public Contract getByMatricule(String matricule) {
        return this.contractRepository.findByMatricule(matricule);
    }


}
