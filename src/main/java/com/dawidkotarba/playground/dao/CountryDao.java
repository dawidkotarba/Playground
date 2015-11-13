package com.dawidkotarba.playground.dao;

import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.model.entities.Country;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

import static com.dawidkotarba.playground.model.entities.QCountry.country;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class CountryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<CountryDto> getCountries() {
        List<Country> result = new JPAQuery(entityManager).from(country).fetchAll().list(country);
        return repackEntities(result);
    }

    public List<CountryDto> getCountriesByName(String name) {
        List<Country> result = new JPAQuery(entityManager).from(country).where(country.name.contains(name)).list(country);
        return repackEntities(result);
    }

    public void addCountry(CountryDto countryDto) {
        Country country = new Country();
        BeanUtils.copyProperties(countryDto, country);
        entityManager.persist(country);
    }

    private List<CountryDto> repackEntities(List<Country> source) {
        List<CountryDto> countryDtos = new ArrayList<>();

        source.forEach(country -> {
            CountryDto countryDto = new CountryDto();
            BeanUtils.copyProperties(country, countryDto);
            countryDtos.add(countryDto);
        });

        return countryDtos;
    }

}
