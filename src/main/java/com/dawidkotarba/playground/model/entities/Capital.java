package com.dawidkotarba.playground.model.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dawid Kotarba on 30.11.2015.
 */

@Entity
@Table(name = "CAPITAL")
@SequenceGenerator(name = "PK", sequenceName = "CAPITAL_SEQ")
public class Capital extends AbstractPersistableSequence {

    private static final long serialVersionUID = -7662351495859298047L;

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
