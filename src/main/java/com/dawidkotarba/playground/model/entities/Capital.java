package com.dawidkotarba.playground.model.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dawid Kotarba on 30.11.2015.
 */

@Entity
@Table(name = "CAPITAL")
public class Capital implements Serializable {

    @Id
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "POPULATION")
    private int population;

    @OneToOne(mappedBy = "capital")
    private Country country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
