package com.dawidkotarba.playground.integration.dto;

import java.io.Serializable;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */
public class UserOutDto implements Serializable {

    private int id;

    private String username;

    private boolean enabled;

    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
