package com.dawidkotarba.playground.integration.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */
public class CountryDto {

    @NotEmpty
    private String name;

    private CapitalDto capital = new CapitalDto();

    private int area;

    private int population;

    @Size(max = 3)
    private String currency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CapitalDto getCapital() {
        return capital;
    }

    public void setCapital(CapitalDto capital) {
        this.capital = capital;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
