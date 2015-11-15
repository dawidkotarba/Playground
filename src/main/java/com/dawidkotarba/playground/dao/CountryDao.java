package com.dawidkotarba.playground.dao;

import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.model.entities.Country;
import com.dawidkotarba.playground.utils.DaoUtils;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @Bean
    public CacheManager countriesCacheManager() {
        return new ConcurrentMapCacheManager("countries");
    }

    public List<CountryDto> getCountries() {
        List<Country> result = new JPAQuery(entityManager).from(country).fetchAll().list(country);
        return DaoUtils.copyProperties(result, CountryDto.class);
    }

    @Cacheable("countries")
    public List<CountryDto> getCountriesByName(String name) {
        List<Country> result = new JPAQuery(entityManager).from(country).where(country.name.containsIgnoreCase(name)).list(country);
        return DaoUtils.copyProperties(result, CountryDto.class);
    }

    public void addCountry(CountryDto countryDto) {
        Country country = new Country();
        BeanUtils.copyProperties(countryDto, country);
        entityManager.persist(country);
    }
}
