package com.dawidkotarba.playground.annotations;

import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Dawid Kotarba on 06.03.2016.
 */

@Component
@WebService
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WebServiceEndpoint {
}
