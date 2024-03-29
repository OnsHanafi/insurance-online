package com.groot.insuranceonline.servicesImpl;

import com.groot.insuranceonline.entities.Beneficiary;
import com.groot.insuranceonline.entities.Contract;
import com.groot.insuranceonline.entities.Insurance;
import com.groot.insuranceonline.enums.ContractType;
import com.groot.insuranceonline.repositories.InsuranceRepository;
import com.groot.insuranceonline.services.BeneficaryService;
import com.groot.insuranceonline.services.ContractService;
import com.groot.insuranceonline.services.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final BeneficaryService beneficaryService;
    private final ContractService contractService;

    @Override
    public Insurance addInsurance(Insurance a, Integer cinBf, String matricule) {
        Beneficiary bf = this.beneficaryService.getBfByCin(cinBf);
        Contract contract = this.contractService.getByMatricule(matricule);
        a.setBeneficiary(bf);
        a.setContract(contract);
        return this.insuranceRepository.save(a);
    }

    @Override
    public float getMontantBybf(int cinBf) {
        float totalMontant = 0 ;
        List<Insurance> insurances = this.insuranceRepository.findAll().stream()
                .filter(insurance -> insurance.getBeneficiary().getCin() == cinBf)
                .collect(Collectors.toList());
        for (Insurance ins:insurances){
           ContractType type = ins.getContract().getType();
           float price = ins.getPrice();
           switch (type){
               case Yearly -> {
                   totalMontant += price;
                   break;
               }
               case HalfYearly -> {
                   totalMontant += price*2;
                   break;
               }
               case Monthly -> {
                   totalMontant += price*12;
                   break;
               }
           }

        }
        return totalMontant;
    }


}
