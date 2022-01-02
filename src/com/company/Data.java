package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Data {

    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Driver> drivers = new ArrayList<>();
    private ArrayList<Ride> rides = new ArrayList<>();
    private ArrayList<Driver> requestedDrivers = new ArrayList<>();
    private ArrayList<String> events = new ArrayList<>();
    private ArrayList<String> discountAreas = new ArrayList<>();
    private ArrayList<Date> holidays = new ArrayList<>();


    private ArrayList<Integer> driverOffer = new ArrayList<>();

    public ArrayList<Date> getHolidays() {
        return holidays;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public ArrayList<Ride> getRides() { return rides; }

    public ArrayList<Driver> getRequestedDrivers() { return requestedDrivers; }

    public ArrayList<Integer> getDriverOffer() { return driverOffer; }

    public ArrayList<String> getEvents() {
        return events;
    }

    public ArrayList<String> getDiscountAreas() {
        return discountAreas;
    }

    public void printClients(){
        for (int i = 0; i<getClients().size(); i++){
            System.out.println(i+1 + ") " +getClients().get(i).getUserName());
        }
    }

    public void printDrivers(){
        for (int i = 0; i<getDrivers().size(); i++){
            System.out.println(i+1 + ") " +getDrivers().get(i).getUserName());
        }
    }


}
