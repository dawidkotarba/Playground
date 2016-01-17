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
import java.util.List;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class CountryDao extends AbstractDao {

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
}
