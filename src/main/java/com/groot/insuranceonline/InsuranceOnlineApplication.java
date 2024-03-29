package com.groot.insuranceonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class InsuranceOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(InsuranceOnlineApplication.class, args);
    }

}
