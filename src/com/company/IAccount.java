package com.company;

public interface IAccount {

    public User Login(Data data, String username, String pass);
    public void register(Data data, User user);
}
