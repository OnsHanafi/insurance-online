package com.groot.insuranceonline.servicesImpl;

import com.groot.insuranceonline.entities.Beneficiary;
import com.groot.insuranceonline.entities.Insurance;
import com.groot.insuranceonline.enums.ContractType;
import com.groot.insuranceonline.repositories.BeneficaryRepository;
import com.groot.insuranceonline.repositories.ContractRepository;
import com.groot.insuranceonline.repositories.InsuranceRepository;
import com.groot.insuranceonline.services.BeneficaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeneficaryServiceImpl implements BeneficaryService {

    private final BeneficaryRepository beneficaryRepository;
    private final InsuranceRepository insuranceRepository;

    @Override
    public Beneficiary addBF(Beneficiary bf) {
        return this.beneficaryRepository.save(bf);
    }

    @Override
    public List<Beneficiary> getAllBenefecaries() {
        return this.beneficaryRepository.findAll();
    }

    @Override
    public Beneficiary getBfByCin(int cinBf) {
        return this.beneficaryRepository.findByCin(cinBf);
    }

    @Override
    public Set<Beneficiary> getBeneficairesByType(ContractType tc) {

        return this.insuranceRepository.findAll().stream()
                .filter(insurance -> insurance.getContract().getType() == tc)
                .map(Insurance::getBeneficiary)
                .collect(Collectors.toSet());


    }
}
