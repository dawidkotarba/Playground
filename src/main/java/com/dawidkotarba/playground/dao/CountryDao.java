package com.dawidkotarba.playground.dao;

import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.model.entities.Country;
import com.google.common.base.Preconditions;
import com.mysema.query.jpa.impl.JPAQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.dawidkotarba.playground.model.entities.QCountry.country;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class CountryDao extends AbstractDao {

    @Bean
    public CacheManager countriesCacheManager() {
        return new ConcurrentMapCacheManager("countries");
    }

    public List<CountryDto> getAll() {
        List<Country> result = new JPAQuery(entityManager).from(country).fetchAll().list(country);
        return copyProperties(result, CountryDto.class);
    }

    @Cacheable("countries")
    public List<CountryDto> getByName(String name) {
        Preconditions.checkArgument(StringUtils.isNotBlank(name), "Name cannot be blank");

        List<Country> result = new JPAQuery(entityManager).from(country).where(country.name.containsIgnoreCase(name)).list(country);
        return copyProperties(result, CountryDto.class);
    }

    public void add(CountryDto countryDto) {
        Preconditions.checkNotNull(countryDto, "countryDto cannot be null");

        Country country = new Country();
        BeanUtils.copyProperties(countryDto, country);
        entityManager.persist(country);
    }
}
