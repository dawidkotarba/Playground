package com.dawidkotarba.playground.integration.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */
@Data
public class CountryDto implements Serializable {

    @NotNull
    private String name;

    @Valid
    private CapitalDto capital = new CapitalDto();

    private int area;

    private int population;

    @Size(max = 3)
    private String currency;

    private Set<String> neighbourCountriesNames = new HashSet<>();
}
