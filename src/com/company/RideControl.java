package com.company;

public class RideControl {

    public void rideSimulation(Driver driver, Client client) throws InterruptedException {

        wait(3000);
        System.out.println("Driver: " + driver.getUserName() + " arrived at client: " + client.getUserName() + "'s location.");
        wait(3000);
        System.out.println("Driver: " + driver.getUserName() + " arrived to client: " + client.getUserName() + "'s destination.");

    }
}