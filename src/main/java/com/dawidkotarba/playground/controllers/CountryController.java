package com.dawidkotarba.playground.controllers;

import com.dawidkotarba.playground.integration.ReportingServiceGateway;
import com.dawidkotarba.playground.integration.dto.CountryDto;
import com.dawidkotarba.playground.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */

@RestController
@RequestMapping(value = "/countries")
public class CountryController {

    private CountryService countryService;

    @Autowired
    private ReportingServiceGateway reportingServiceGateway;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Resource<CountryDto>> getAll() {
        return createResourceResults(countryService.getAll());
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Resource<CountryDto>> getByName(@PathVariable String name) {
        return createResourceResults(countryService.getByName(name));
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody @Valid CountryDto countryDto) {
        countryService.add(countryDto);
    }

    private List<Resource<CountryDto>> createResourceResults(List<CountryDto> dtos) {
        List<Resource<CountryDto>> result = new ArrayList<>();

        for (CountryDto dto : dtos) {
            Resource resource = new Resource(dto);
            resource.add(linkTo(methodOn(CountryController.class).getByName(dto.getName())).withSelfRel());
            result.add(resource);
        }
        return result;
    }

    @RequestMapping(value = "/integration{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String testIntegration(@PathVariable String name) {
        return reportingServiceGateway.generateReport(name);
    }
}
