package com.groot.insuranceonline.controlles;

import com.groot.insuranceonline.entities.Insurance;
import com.groot.insuranceonline.services.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/insurance")
@RequiredArgsConstructor
public class InsuranceController {

    private final InsuranceService insuranceService;

    @PostMapping("/add/bf/{cin-bf}/contract/{matricule}")
    public Insurance ajouterAssurance(@RequestBody Insurance a, @PathVariable("cin-bf") Integer cinBf,@PathVariable("matricule") String matricule){
        return this.insuranceService.addInsurance(a,cinBf,matricule);
    }

}
