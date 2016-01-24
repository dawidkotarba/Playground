package com.dawidkotarba.playground.dao;

import com.dawidkotarba.playground.integration.assembler.CountryAssembler;
import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.model.entities.Country;
import com.dawidkotarba.playground.repository.CountryRepository;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class CountryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private CountryRepository countryRepository;

    public List<CountryDto> getAll() {
        List<Country> result = (List<Country>) countryRepository.findAll();
        return CountryAssembler.convertToDto(result);
    }

    @Cacheable("countriesCache")
    public List<CountryDto> getByName(String name) {
        Preconditions.checkArgument(StringUtils.isNotBlank(name), "Name cannot be blank");
        List<Country> result = countryRepository.findByName(name);
        return CountryAssembler.convertToDto(result);
    }

    public void add(CountryDto countryDto) {
        Preconditions.checkNotNull(countryDto, "countryDto cannot be null");
        entityManager.persist(CountryAssembler.convert(countryDto));
    }

    /*
    // ================ example of JPA Criteria API ================

        public List<CountryDto> getAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> countryCriteriaQuery = criteriaBuilder.createQuery(Country.class);

        Root<Country> from = countryCriteriaQuery.from(Country.class);
        CriteriaQuery<Country> select = countryCriteriaQuery.select(from);

        TypedQuery<Country> typedQuery = entityManager.createQuery(select);
        List<Country> result = typedQuery.getResultList();

        return CountryAssembler.convertToDto(result);
    }

    @Cacheable("countriesCache")
    public List<CountryDto> getByName(String name) {
        Preconditions.checkArgument(StringUtils.isNotBlank(name), "Name cannot be blank");

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> countryCriteriaQuery = criteriaBuilder.createQuery(Country.class);

        Root<Country> from = countryCriteriaQuery.from(Country.class);
        CriteriaQuery<Country> select = countryCriteriaQuery.select(from);

        Predicate namePredicate = criteriaBuilder.equal(from.get("name"), name);

        select.where(namePredicate);

        TypedQuery<Country> typedQuery = entityManager.createQuery(select);
        List<Country> result = typedQuery.getResultList();

        return CountryAssembler.convertToDto(result);
    }

    // ================ example of Querydsl ================

      public List<CountryDto> getAll() {
        List<Country> result = new JPAQuery(entityManager).from(country).fetchAll().list(country);
        return CountryAssembler.convertToDto(result);
    }

    @Cacheable("countriesCache")
    public List<CountryDto> getByName(String name) {
        Preconditions.checkArgument(StringUtils.isNotBlank(name), "Name cannot be blank");

        List<Country> result = new JPAQuery(entityManager).from(country).where(country.name.containsIgnoreCase(name)).list(country);
        return CountryAssembler.convertToDto(result);
    }

     */
}
