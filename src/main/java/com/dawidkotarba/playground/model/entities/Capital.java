package com.dawidkotarba.playground.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Dawid Kotarba on 30.11.2015.
 */

@Entity
@Table(name = "CAPITALS")
@SequenceGenerator(name = "PK", sequenceName = "CAPITALS_SEQ", allocationSize = 1)
public class Capital extends AbstractPersistableSequence {

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
