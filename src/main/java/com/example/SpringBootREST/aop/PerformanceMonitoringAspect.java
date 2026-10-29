package com.example.SpringBootREST.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {

    private static  final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);


    @Around("execution(* com.example.SpringBootREST.Service.*.*(..))")
    public Object timetaken(ProceedingJoinPoint jp) throws Throwable {

        long start = System.currentTimeMillis();
        Object obj = jp.proceed();
        long end = System.currentTimeMillis();
        LOGGER.info("method "+ jp.getSignature().getName() + " executed in " + (-start + end) +"ms");

        return obj;

    }



}
