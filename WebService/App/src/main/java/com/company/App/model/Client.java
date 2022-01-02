package com.company.App.model;

import com.company.App.data.Data;
import com.company.App.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.Date;

public class Client extends User  {

    Data data;
    private ArrayList<String> driversOffers = new ArrayList<>();
    private ArrayList<Driver> offerdDrivers = new ArrayList<>();
    private ClientService clientService = new ClientService(this, data);
    private boolean firstRide;

    @Autowired
    public Client(String userName, String mobileNum, String email, String password, Date birthdate, @Qualifier("dataObj") Data data) {
        super(userName, mobileNum, email, password, birthdate);
        firstRide = true;
        this.data = data;
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

    public ClientService getClientControl() {
        return clientService;
    }

    public ArrayList<String> getDriversOffers() {
        return driversOffers;
    }

    public void setDriversOffers(ArrayList<String> driversOffers) {
        this.driversOffers = driversOffers;
    }
}
