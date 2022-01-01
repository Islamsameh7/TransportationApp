package com.company.App.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Client extends User  {

    private ArrayList<String> driversOffers = new ArrayList<>();
    private ArrayList<Driver> offerdDrivers = new ArrayList<>();

    public Client(@JsonProperty("username") String userName,
                  @JsonProperty("mobile") String mobileNum,
                  @JsonProperty("email") String email,
                  @JsonProperty("password") String password) {
        super(userName, mobileNum, email, password);
    }

    public ArrayList<Driver> getOfferdDrivers() {
        return offerdDrivers;
    }

    public ArrayList<String> getDriversOffers() {
        return driversOffers;
    }

    public void setDriversOffers(ArrayList<String> driversOffers) {
        this.driversOffers = driversOffers;
    }
}
