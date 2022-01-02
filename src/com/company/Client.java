package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Client extends User  {

    private ArrayList<String> driversOffers = new ArrayList<>();
    private ArrayList<Driver> offerdDrivers = new ArrayList<>();
    private ClientControl clientControl = new ClientControl(this);
    private boolean firstRide;

    public Client(String userName, String mobileNum, String email, String password, Date birthdate) {
        super(userName, mobileNum, email, password, birthdate);
        firstRide = true;
    }

    public boolean isFirstRide() {
        return firstRide;
    }

    public void setFirstRide(boolean firstRide) {
        this.firstRide = firstRide;
    }

    public ArrayList<Driver> getOfferdDrivers() {
        return offerdDrivers;
    }

    public ClientControl getClientControl() {
        return clientControl;
    }

    public ArrayList<String> getDriversOffers() {
        return driversOffers;
    }

    public void setDriversOffers(ArrayList<String> driversOffers) {
        this.driversOffers = driversOffers;
    }
}
