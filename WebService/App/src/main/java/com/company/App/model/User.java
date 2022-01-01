package com.company.App.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class User{
    private String userName;
    private String mobileNum;
    private String email;
    private String password;
    private int userID;

    public User(@JsonProperty("username") String userName,
                @JsonProperty("mobile") String mobileNum,
                @JsonProperty("email") String email,
                @JsonProperty("password") String password) {
        this.userName = userName;
        this.mobileNum = mobileNum;
        this.email = email;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getUserID() {
        return userID;
    }
}
