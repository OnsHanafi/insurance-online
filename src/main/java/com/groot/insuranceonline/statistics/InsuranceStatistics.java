package com.groot.insuranceonline.statistics;

import com.groot.insuranceonline.entities.Insurance;
import com.groot.insuranceonline.repositories.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component
@RequiredArgsConstructor
public class InsuranceStatistics {

    private final InsuranceRepository insuranceRepository;

    //se declenche chaque 60s
    @Scheduled(cron = "*/2 * * * * *")
    public void statistiques(){
        //tree map : stats nombre assurances et cin benef
        //par ordre decroissant
        TreeMap<Integer,Integer> stats = new TreeMap<>(Collections.reverseOrder());
        List<Insurance> insurances = this.insuranceRepository.findAll();
        //get nb assurances for each benef
        insurances.forEach(insurance -> {
            Integer benefCin = insurance.getBeneficiary().getCin();
            Integer nbAssurances = (int)insurances.stream()
                    .filter(i -> i.getBeneficiary().getCin() == benefCin)
                    .count();
            stats.put(nbAssurances, benefCin);
        });

        for (Map.Entry<Integer,Integer>entry: stats.entrySet()){
            System.out.println("NB_ASSURANCES :" +entry.getKey()+ " CIN :"+entry.getValue());
        }



    }
}
