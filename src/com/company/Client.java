package com.company;

import java.util.ArrayList;

public class Client extends User  {

    private ArrayList<String> driversOffers = new ArrayList<>();

    public Client(String userName, String mobileNum, String email, String password) {
        super(userName, mobileNum, email, password);
    }

    public ArrayList<String> getDriversOffers() {
        return driversOffers;
    }

    public void setDriversOffers(ArrayList<String> driversOffers) {
        this.driversOffers = driversOffers;
    }
}
