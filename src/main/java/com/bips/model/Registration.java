package com.bips.model;

import javax.validation.constraints.Pattern;

/**
 * Created by ahadcse on 24/03/16.
 */
public class Registration {

    private String username;
    private String password;

    // @Pattern(regexp = "^[a-z0-9_-]{3,15}$", message = "Unsupported username.")
    public String getUsername() {
        return username;
    }

    // @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Unsupported password.")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
