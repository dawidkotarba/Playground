package com.dawidkotarba.playground.model.entities;

import javax.persistence.*;

/**
 * Created by Dawid Kotarba on 19.12.2015.
 */
@MappedSuperclass
public abstract class AbstractPersistableSequence implements HasId<Long> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "PK", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Override
    public Long getId() {
        return null;
    }
}
