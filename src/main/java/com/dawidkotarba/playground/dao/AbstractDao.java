package com.dawidkotarba.playground.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public abstract class AbstractDao {

    @PersistenceContext
    protected EntityManager entityManager;
}
