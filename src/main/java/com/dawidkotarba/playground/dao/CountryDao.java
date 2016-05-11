package com.dawidkotarba.playground.dao;

import com.dawidkotarba.playground.annotations.TransactionalRepository;
import com.dawidkotarba.playground.integration.assembler.CountryAssembler;
import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.model.entities.Country;
import com.dawidkotarba.playground.repository.CountryRepository;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */

@TransactionalRepository
public class CountryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private CountryRepository countryRepository;

    @Autowired
    private CountryAssembler countryAssembler;

    public List<CountryDto> getAll() {
        List<Country> result = countryRepository.findAll();
        return countryAssembler.convertToDto(result);
    }

    @Cacheable("countriesCache")
    public List<CountryDto> getByName(String name) {
        Preconditions.checkArgument(StringUtils.isNotBlank(name), "Name cannot be blank");
        List<Country> result = countryRepository.findByName(name);
        return countryAssembler.convertToDto(result);
    }

    public void add(CountryDto countryDto) {
        Preconditions.checkNotNull(countryDto, "countryDto cannot be null");

        Country country = countryAssembler.convert(countryDto);
        entityManager.persist(country);
    }

    public Page<CountryDto> getAll(Pageable pageable) {
        Page<Country> all = countryRepository.findAll(pageable);
        List<Country> content = all.getContent();
        List<CountryDto> countryDtos = countryAssembler.convertToDto(content);
        return new PageImpl<>(countryDtos, pageable, countryDtos.size());
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

        return countryAssembler.convertToDto(result);
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

        return countryAssembler.convertToDto(result);
    }

    // ================ example of Querydsl ================

      public List<CountryDto> getAll() {
        List<Country> result = new JPAQuery(entityManager).from(country).fetchAll().list(country);
        return countryAssembler.convertToDto(result);
    }

    @Cacheable("countriesCache")
    public List<CountryDto> getByName(String name) {
        Preconditions.checkArgument(StringUtils.isNotBlank(name), "Name cannot be blank");

        List<Country> result = new JPAQuery(entityManager).from(country).where(country.name.containsIgnoreCase(name)).list(country);
        return countryAssembler.convertToDto(result);
    }

     */
}
