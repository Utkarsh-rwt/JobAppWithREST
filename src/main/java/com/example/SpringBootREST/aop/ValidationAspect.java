package com.example.SpringBootREST.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ValidationAspect {

    public static  final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);


    @Around("execution (* com.example.SpringBootREST.Service.*.*(..))  &&  args(postId)")
    public  Object  Validator (ProceedingJoinPoint jp, int postId) throws Throwable {
        if (postId<0) {
            LOGGER.info("PostId is negative, updating it");
            postId=-postId;
            LOGGER.info("new Value "+postId);
        }

        Object obj =jp.proceed(new Object[] {postId});

        return obj;

    }



}
