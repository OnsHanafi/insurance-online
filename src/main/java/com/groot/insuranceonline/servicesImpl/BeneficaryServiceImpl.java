package com.groot.insuranceonline.servicesImpl;

import com.groot.insuranceonline.entities.Beneficiary;
import com.groot.insuranceonline.repositories.BeneficaryRepository;
import com.groot.insuranceonline.services.BeneficaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeneficaryServiceImpl implements BeneficaryService {

    private final BeneficaryRepository beneficaryRepository;

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
}
