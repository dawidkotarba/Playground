package com.dawidkotarba.playground.dao;

import com.dawidkotarba.playground.model.entities.Country;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */

@Repository
public class CountryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Country> getCountries() {

        TypedQuery<Country> query = entityManager.createQuery("SELECT c FROM Country c", Country.class);
        List<Country> countries = query.getResultList();

        return countries;
    }

}
