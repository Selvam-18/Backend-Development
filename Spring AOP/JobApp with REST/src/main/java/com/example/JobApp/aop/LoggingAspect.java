package com.example.JobApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.JobApp.service.JobService.*(..))")
    public void beforeLogMethodCall(JoinPoint jp) {
        LOGGER.info("Method called before" + jp.getSignature().getName());
    }

    @After("execution(* com.example.JobApp.service.JobService.*(..))")
    public void afterLogMethodCall(JoinPoint jp) {
        LOGGER.info("Method called After" + jp.getSignature().getName());
    }

    @Around("execution(* com.example.JobApp.service.JobService.*(..))")
    public Object aroundLogMethod(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();

        Object obj = pjp.proceed();

        long end = System.currentTimeMillis();

        LOGGER.info("Method " + pjp.getSignature().getName() + " has taken " +(end - start) + "ms");

        return obj;
    }

}
