package com.dawidkotarba.playground.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by Dawid Kotarba on 13.11.2015.
 */
@Aspect
@Component
public class RepositoryLoggerAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Around("execution(* com.dawidkotarba.playground.dao.*.*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        LOGGER.info("Execution time of {}: {} ms", pjp.getSignature(), elapsedTime);

        return output;
    }

}
