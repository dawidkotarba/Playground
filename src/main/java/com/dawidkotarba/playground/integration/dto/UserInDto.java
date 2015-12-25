package com.dawidkotarba.playground.integration.dto;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */
public class UserInDto implements Serializable {

    private static final long serialVersionUID = 6434136545021517484L;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private boolean enabled;

    @NotEmpty
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
