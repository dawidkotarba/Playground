package com.dawidkotarba.playground.controller;

import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/countries/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryDto> listCountries() {
        return countryService.getCountries();
    }

    @RequestMapping(value = "/countries/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryDto> getCountriesByName(@PathVariable String name) {
        return countryService.getCountriesByName(name);
    }

    @RequestMapping(value = "/countries/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addCountry(@RequestBody CountryDto countryDto) {
        countryService.addCountry(countryDto);
    }
}
