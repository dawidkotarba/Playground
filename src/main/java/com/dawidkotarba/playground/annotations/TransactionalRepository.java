package com.dawidkotarba.playground.annotations;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Dawid Kotarba on 08.02.2016.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionalRepository {
}
