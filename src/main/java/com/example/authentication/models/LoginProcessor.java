package com.example.authentication.models;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private String username;
    private String password;

    public boolean login() {
        String username = this.getName();
        String password = this.getPassword();
        if ("adra".equals(username) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
