package com.groot.insuranceonline.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BonCourageAspect {

    @Pointcut("execution(* com.groot.insuranceonline.servicesImpl.*.get*(..))")
    public void getMethods(){}

    @After("getMethods()")
    public void sayBonCourage(){
        System.out.println("Bon Courage !! ");
    }

}
