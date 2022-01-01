package com.company.App.data;

import com.company.App.model.Client;
import com.company.App.model.Driver;
import com.company.App.model.Ride;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Scanner;

@Repository("data")
public class Data {

    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Driver> drivers = new ArrayList<>();
    private ArrayList<Ride> rides = new ArrayList<>();
    private ArrayList<Driver> requestedDrivers = new ArrayList<>();
    private ArrayList<String> events = new ArrayList<>();
    private ArrayList<String> discountAreas = new ArrayList<>();
    public static Scanner input = new Scanner(System.in);


    public ArrayList<Integer> driverOffer = new ArrayList<>();

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
