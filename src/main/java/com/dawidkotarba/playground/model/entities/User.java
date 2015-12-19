package com.dawidkotarba.playground.model.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dawid Kotarba on 15.11.2015.
 */

@Entity
@Table(name = "USER")
@SequenceGenerator(name = "PK", sequenceName = "USER_SEQ")
public class User extends AbstractPersistableSequence {

    private static final long serialVersionUID = -2938845917673965315L;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ENABLED", nullable = false)
    private boolean enabled;

    @Column(name = "ROLE", nullable = false)
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
