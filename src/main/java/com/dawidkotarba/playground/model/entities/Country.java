package com.dawidkotarba.playground.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Dawid Kotarba on 12.11.2015.
 */

@Entity
@Table(name = "COUNTRY")
public class Country implements Serializable {

    @Id
    @Column(name = "NAME")
    private String name;

    @Column(name = "LANGUAGE")
    private String language;

    @Column(name = "AREA")
    private int area;

    @Column(name = "POPULATION")
    private int population;

    @Column(name = "CURRENCY")
    private String currency;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
