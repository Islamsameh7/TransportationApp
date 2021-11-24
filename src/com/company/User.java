package com.company;

public abstract class User{
    private String userName;
    private String mobileNum;
    private String email;
    private String password;
    private int userID;

    public User(String userName, String mobileNum, String email, String password) {
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
