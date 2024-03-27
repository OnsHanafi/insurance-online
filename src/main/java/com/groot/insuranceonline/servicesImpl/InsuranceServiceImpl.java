package com.groot.insuranceonline.servicesImpl;

import com.groot.insuranceonline.entities.Beneficiary;
import com.groot.insuranceonline.entities.Contract;
import com.groot.insuranceonline.entities.Insurance;
import com.groot.insuranceonline.repositories.InsuranceRepository;
import com.groot.insuranceonline.services.BeneficaryService;
import com.groot.insuranceonline.services.ContractService;
import com.groot.insuranceonline.services.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final BeneficaryService beneficaryService;
    private final ContractService contractService;

    @Override
    public Insurance addInsurance(Insurance a, Integer cinBf, String matricule) {
        System.out.println(cinBf);
        System.out.printf(matricule);
        Beneficiary bf = this.beneficaryService.getBfByCin(cinBf);
        Set<Insurance> ins = bf.getInsurances();
        Contract contract = this.contractService.getByMatricule(matricule);
        a.setBeneficiary(bf);
        a.setContract(contract);
        return this.insuranceRepository.save(a);
    }

    @Override
    public List<Insurance> getInsuranceByBenfId(int idBf) {
        return this.insuranceRepository.findInsuranceByBeneficiaryId(idBf);
    }
}
