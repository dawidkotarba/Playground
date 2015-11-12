package com.dawidkotarba.playground.dao;

import com.dawidkotarba.playground.model.entities.Country;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static com.dawidkotarba.playground.model.entities.QCountry.country;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */

@Repository
public class CountryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Country> getCountries() {
        List<Country> countries = new JPAQuery(entityManager).from(country).fetchAll().list(country);
        return countries;
    }

}
