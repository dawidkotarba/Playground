package com.dawidkotarba.playground.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Dawid Kotarba on 13.11.2015.
 */
@Aspect
@Component
public class RepositoryLoggerAspect {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    @Around("execution(* com.dawidkotarba.playground.dao.*.*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        LOGGER.log(Level.INFO, "Execution time of " + pjp.getSignature() + ": " + elapsedTime + " ms");
        return output;
    }

}
