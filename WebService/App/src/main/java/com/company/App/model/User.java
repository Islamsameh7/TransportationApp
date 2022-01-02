package com.company.App.model;

import java.util.Date;

public abstract class User{
    private String userName;
    private String mobileNum;
    private String email;
    private String password;
    private int userID;
    private Date birthdate;

    public User(String userName, String mobileNum, String email, String password, Date birthdate) {
        this.userName = userName;
        this.mobileNum = mobileNum;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
    }

    public Date getBirthdate() {
        return birthdate;
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
