package com.company;

import java.text.ParseException;

public interface IAccount {

    public User Login(String username, String pass);
    public void register() throws ParseException;
}
