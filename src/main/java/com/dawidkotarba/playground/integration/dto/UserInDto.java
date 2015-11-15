package com.dawidkotarba.playground.integration.dto;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */
public class UserInDto {

    private String username;

    private String password;

    private boolean enabled;

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
}
