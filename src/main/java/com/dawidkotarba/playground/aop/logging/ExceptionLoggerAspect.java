package com.dawidkotarba.playground.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Dawid Kotarba on 20.11.2015.
 */

@Aspect
@Component
public class ExceptionLoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.dawidkotarba.playground.dao..*)"
            + "|| within(com.dawidkotarba.playground.service..*)"
            + "|| within(com.dawidkotarba.playground.controllers..*)")
    public void loggingPointcut() {
        // intentionally left blank
    }

    @AfterThrowing(pointcut = "loggingPointcut()", throwing = "e")
    public void logException(JoinPoint joinPoint, Throwable e) {
        logger.error("Exception in {}.{}() with cause = {} and exception {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getCause(), e);
    }

}
