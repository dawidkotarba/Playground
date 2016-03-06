package com.dawidkotarba.playground.endpoints;

import com.dawidkotarba.playground.annotations.WebServiceEndpoint;
import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebMethod;
import java.util.List;

/**
 * Created by Dawid Kotarba on 06.03.2016.
 */

@WebServiceEndpoint
public class CountryEndpoint {

    @Autowired
    private CountryService countryService;

    @WebMethod
    public List<CountryDto> getAll() {
        return countryService.getAll();
    }
}
