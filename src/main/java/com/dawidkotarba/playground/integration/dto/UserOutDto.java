package com.dawidkotarba.playground.integration.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */

@Data
public class UserOutDto implements Serializable {

    private int id;

    private String username;

    private boolean enabled;

    private String role;
}
