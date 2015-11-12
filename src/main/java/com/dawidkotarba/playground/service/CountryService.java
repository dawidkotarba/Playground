package com.dawidkotarba.playground.service;

import com.dawidkotarba.playground.dao.CountryDao;
import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.model.entities.Country;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */

@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public List<CountryDto> getCountries() {

        List<CountryDto> countryDtos = new ArrayList<>();

        List<Country> countries = countryDao.getCountries();

        for (Country country : countries) {
            CountryDto countryDto = new CountryDto();
            BeanUtils.copyProperties(country, countryDto);
            countryDtos.add(countryDto);
        }

        return countryDtos;
    }
}
