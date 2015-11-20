package com.dawidkotarba.playground.aop.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Dawid Kotarba on 20.11.2015.
 */

@Aspect
public class ExceptionLoggerAspect {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.dawidkotarba.playground.dao..*) || com.dawidkotarba.playground.service..*) || com.dawidkotarba.playground.controllers..*)")
    public void loggingPointcut() {
        // intentionally left blank
    }

    @AfterThrowing(pointcut = "loggingPointcut()", throwing = "e")
    public void logException(JoinPoint joinPoint, Throwable e) {
        LOGGER.error("Exception in {}.{}() with cause = {} and exception {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getCause(), e);
    }

}
