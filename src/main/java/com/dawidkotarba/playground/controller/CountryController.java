package com.dawidkotarba.playground.controller;

import com.dawidkotarba.playground.model.entities.Country;
import com.dawidkotarba.playground.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping("/countries")
    public List<Country> listCountries() {
        return countryService.getCountries();
    }
}
