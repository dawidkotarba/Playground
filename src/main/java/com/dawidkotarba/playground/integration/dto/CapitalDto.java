package com.dawidkotarba.playground.integration.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Dawid Kotarba on 30.11.2015.
 */
@Data
public class CapitalDto implements Serializable {

    @NotNull
    private String name;

    private int population;
}
