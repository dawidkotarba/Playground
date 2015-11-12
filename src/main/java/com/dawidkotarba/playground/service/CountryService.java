package com.dawidkotarba.playground.service;

import com.dawidkotarba.playground.dao.CountryDao;
import com.dawidkotarba.playground.model.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */

@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public List<Country> getCountries() {
        return countryDao.getCountries();
    }
}
