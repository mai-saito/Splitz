package com.splitz.api.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aop {

    // method to log aspect
    @Around("execution(* *..*Controller.*(..)) || execution(* *..*Service.*(..)) || execution(* *..*Repository.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Start: " + joinPoint.getSignature());
        try {
            Object result = joinPoint.proceed();
            System.out.println("End: " + joinPoint.getSignature());
            return result;
        } catch (Exception e) {
            System.out.println("==============================================");
            System.out.println("Exception occurred!");
            System.out.println("----------------------------------------------");
            e.printStackTrace();
            System.out.println("==============================================");
            throw e;
        }
    }
}
