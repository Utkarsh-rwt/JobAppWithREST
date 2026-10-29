package com.example.SpringBootREST.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.SpringBootREST.Service.*.*(..))")
    public void logMethodCall(JoinPoint jp){

        String method =  jp.getSignature().getName();
        LOGGER.info("Method Called : " + method );

    }

}
