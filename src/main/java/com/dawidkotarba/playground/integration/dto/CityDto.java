package com.dawidkotarba.playground.integration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * Created by Dawid Kotarba on 08.02.2016.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {

    @NotNull
    private String name;

    private int population;

}
