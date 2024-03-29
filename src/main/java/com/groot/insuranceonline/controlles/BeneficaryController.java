package com.groot.insuranceonline.controlles;

import com.groot.insuranceonline.entities.Beneficiary;
import com.groot.insuranceonline.enums.ContractType;
import com.groot.insuranceonline.services.BeneficaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/beneficaries")
@RequiredArgsConstructor
public class BeneficaryController {


    private final BeneficaryService beneficaryService;

    @GetMapping()
    public List<Beneficiary> getBeneficaries(){
        return this.beneficaryService.getAllBenefecaries();
    }

    @PostMapping("/add")
    public Beneficiary addBeneficiary(@RequestBody Beneficiary bf){
       return this.beneficaryService.addBF(bf);
    }

    @GetMapping("/contract-type/{contract-type}")
    public Set<Beneficiary> getBeneficairesByType (@PathVariable("contract-type") ContractType tc){
        return this.beneficaryService.getBeneficairesByType(tc);
    }

}
