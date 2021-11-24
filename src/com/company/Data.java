package com.company;

import java.util.ArrayList;

public class Data {

    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Driver> drivers = new ArrayList<>();
    private ArrayList<Ride> rides = new ArrayList<>();
    private ArrayList<Driver> requestedDrivers = new ArrayList<>();
    private ArrayList<String> favAreas = new ArrayList<>();
    private ArrayList<String> driverNotifications = new ArrayList<>();
    private ArrayList<Integer> driverOffer = new ArrayList<>();

    public ArrayList<Client> getClients() {
        return clients;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public ArrayList<Ride> getRides() { return rides; }

    public ArrayList<Driver> getRequestedDrivers() { return requestedDrivers; }

    public ArrayList<String> getFavAreas() { return favAreas; }

    public ArrayList<String> getDriverNotifications() { return driverNotifications; }

    public ArrayList<Integer> getDriverOffer() { return driverOffer; }

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
