package com.example.JobApp.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.example.JobApp.service.JobService.getJob(..)) && args(postId)")
    public Object validateInput(ProceedingJoinPoint pjp, int postId) throws Throwable {

        if (postId < 0) {
            LOGGER.info("Negative value found");
            postId = -postId;
            LOGGER.info("Validated into Postitive " + postId);
        }
        Object obj = pjp.proceed(new Object[]{postId});

        return obj;
    }

}
