package com.dawidkotarba.playground.integration.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by Dawid Kotarba on 08.02.2016.
 */

@Data
public class CityDto {

    @NotNull
    private String name;

    private int population;
}
