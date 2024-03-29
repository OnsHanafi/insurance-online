package com.groot.insuranceonline.controlles;

import com.groot.insuranceonline.entities.Insurance;
import com.groot.insuranceonline.services.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/insurances")
@RequiredArgsConstructor
public class InsuranceController {

    private final InsuranceService insuranceService;

    @PostMapping("/add/bf/{cin-bf}/contract/{matricule}")
     public Insurance ajouterAssurance(@RequestBody Insurance a, @PathVariable("cin-bf") Integer cinBf,@PathVariable("matricule") String matricule){
         return this.insuranceService.addInsurance(a,cinBf,matricule);
     }

     @GetMapping("/montant-bf/{cinBf}")
    public float getMontantBf (@PathVariable int cinBf){
         System.out.println(cinBf);
        return this.insuranceService.getMontantBybf(cinBf);
     }

}
