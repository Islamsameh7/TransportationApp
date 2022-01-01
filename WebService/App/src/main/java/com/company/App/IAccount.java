package com.company.App;

import com.company.App.model.User;

public interface IAccount {

    public User Login(String username, String pass);
    public void register();
}
