package com.dawidkotarba.playground.repository;

import com.dawidkotarba.playground.model.entities.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Dawid Kotarba on 17.01.2016.
 */
public interface CountryRepository extends CrudRepository<Country, Long> {
    List<Country> findByName(String name);
}
