package com.groot.insuranceonline.controlles;

import com.groot.insuranceonline.entities.Contract;
import com.groot.insuranceonline.services.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contracts")
@RequiredArgsConstructor
public class ContractController {

    private final ContractService contractService;

    @PostMapping
    public Contract ajouterContrat(@RequestBody Contract c){
        return this.contractService.addContrat(c);
    }

    @GetMapping("/oldest-contract/{id-bf}")
    public Contract getContractBf(@PathVariable("id-bf") int idBf){
        return this.contractService.getOldestContractBeneficairy(idBf);
    }

}
