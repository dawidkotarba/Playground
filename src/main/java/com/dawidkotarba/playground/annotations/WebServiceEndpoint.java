package com.dawidkotarba.playground.annotations;

import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.lang.annotation.*;

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
