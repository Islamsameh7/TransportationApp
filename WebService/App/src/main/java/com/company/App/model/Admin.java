package com.company.App.model;

import org.springframework.stereotype.Repository;

@Repository("admin")
public class Admin {

    private String username;
    private String password;

    public Admin(){
        username = "admin";
        password = "admin";
    }

    public String getUsername() { return username; }

    public String getPassword() {
        return password;
    }


}
