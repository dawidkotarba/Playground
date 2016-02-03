package com.dawidkotarba.playground.aop.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Dawid Kotarba on 20.11.2015.
 */

@Aspect
@Component
@Slf4j
public class ExceptionLoggerAspect {

    @Pointcut("within(com.dawidkotarba.playground.dao..*)"
            + "|| within(com.dawidkotarba.playground.service..*)"
            + "|| within(com.dawidkotarba.playground.controllers..*)")
    public void loggingPointcut() {
        // intentionally left blank
    }

    @AfterThrowing(pointcut = "loggingPointcut()", throwing = "e")
    public void logException(JoinPoint joinPoint, Throwable e) {
        log.error("Exception in {}.{}() with cause = {} and exception {}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(), e.getCause(), e);
    }

}
