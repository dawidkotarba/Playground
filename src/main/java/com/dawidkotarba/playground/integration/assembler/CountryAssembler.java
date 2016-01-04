package com.dawidkotarba.playground.integration.assembler;

import com.dawidkotarba.playground.integration.dto.CapitalDto;
import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.model.entities.Capital;
import com.dawidkotarba.playground.model.entities.Country;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

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

        CapitalDto capitalDto = new CapitalDto();
        BeanUtils.copyProperties(country.getCapital(), capitalDto);

        countryDto.setCapital(capitalDto);
		
		 country.getNeighbours().forEach(neighbour -> countryDto.getNeighbourCountriesNames().add(neighbour.getName()));

        return countryDto;
    }

    public static Country convert(CountryDto countryDto) {
        Country country = new Country();
        BeanUtils.copyProperties(countryDto, country);

        Capital capital = new Capital();
        BeanUtils.copyProperties(countryDto.getCapital(), capital);
        country.setCapital(capital);
        return country;
    }

    public static List<CountryDto> convertToDto(List<Country> countries) {
        List<CountryDto> result = new ArrayList<>();
        countries.forEach(country -> result.add(convert(country)));
        return result;
    }

    public static List<Country> convertToEntity(List<CountryDto> countries) {
        List<Country> result = new ArrayList<>();
        countries.forEach(country -> result.add(convert(country)));
        return result;
    }
}
