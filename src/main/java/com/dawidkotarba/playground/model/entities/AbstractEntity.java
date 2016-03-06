package com.dawidkotarba.playground.model.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Created by Dawid Kotarba on 19.12.2015.
 */
@MappedSuperclass
public abstract class AbstractEntity implements HasId<Long>, HasVersion<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "PK", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Version
    private Integer version;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Integer getVersion() {
        return version;
    }
}
