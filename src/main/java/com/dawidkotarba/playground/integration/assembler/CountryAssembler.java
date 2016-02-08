package com.dawidkotarba.playground.integration.assembler;

import com.dawidkotarba.playground.integration.dto.CityDto;
import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.model.entities.City;
import com.dawidkotarba.playground.model.entities.Country;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Dawid Kotarba on 01.12.2015.
 */
public class CountryAssembler {

    private CountryAssembler() {
        // intentionally left blank
    }

    public static CountryDto convert(Country country) {
        CountryDto countryDto = new CountryDto();
        BeanUtils.copyProperties(country, countryDto);
        countryDto.setCapital(assembleCapital(country.getCapital()));
        countryDto.setCities(assembleCities(country));
        countryDto.setNeighbourCountriesNames(assembleNeighbourNames(country));

        return countryDto;
    }

    private static CityDto assembleCapital(City capital) {
        CityDto capitalDto = new CityDto();
        capitalDto.setName(capital.getName());
        capitalDto.setPopulation(capital.getPopulation());
        return capitalDto;
    }

    private static Set<String> assembleNeighbourNames(Country country) {
        Set<String> neighboursNames = new LinkedHashSet<>();
        country.getNeighbours().forEach(neighbour ->
                neighboursNames.add(neighbour.getName()));

        return neighboursNames;
    }

    private static Set<CityDto> assembleCities(Country country) {
        Set<CityDto> cites = new LinkedHashSet<>();
        country.getCities().forEach(city -> {
                    CityDto cityDto = new CityDto();
                    cityDto.setName(city.getName());
                    cityDto.setPopulation(city.getPopulation());
                    cites.add(cityDto);
                }
        );
        return cites;
    }

    public static Country convert(CountryDto countryDto) {
        Country country = new Country();
        BeanUtils.copyProperties(countryDto, country);
        country.setCapital(assembleCapital(countryDto, country));
        return country;
    }

    private static City assembleCapital(CountryDto countryDto, Country country) {
        City capital = new City();
        capital.setName(countryDto.getCapital().getName());
        capital.setPopulation(countryDto.getCapital().getPopulation());
        capital.setCountry(country);
        return capital;
    }

    public static List<CountryDto> convertToDto(List<Country> countries) {
        List<CountryDto> result = new ArrayList<>();
        countries.forEach(country -> result.add(convert(country)));
        return result;
    }
}
