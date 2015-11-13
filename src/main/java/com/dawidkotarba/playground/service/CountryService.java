package com.dawidkotarba.playground.service;

import com.dawidkotarba.playground.dao.CountryDao;
import com.dawidkotarba.playground.integration.dto.CountryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */

@Service
@Transactional
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public List<CountryDto> getCountries() {
        return countryDao.getCountries();
    }

    public List<CountryDto> getCountriesByName(String name) {
        return countryDao.getCountriesByName(name);
    }

    public void addCountry(CountryDto countryDto) {
        countryDao.addCountry(countryDto);
    }
}