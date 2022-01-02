package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Driver extends User {

    private int license, nationalID, numOfSeats;
    private String location;
    private double avgRating, balance;
    private boolean availableForRide;
    private ArrayList<String> userRating = new ArrayList<>();
    private ArrayList<Integer> ratingList = new ArrayList<>();
    private ArrayList<String> favAreas = new ArrayList<>();
    private ArrayList<String> driverNotifications = new ArrayList<>();
    DriverControl driverControl= new DriverControl(this);

    public Driver(String userName, String mobileNum, String email, String password, Date birthdate, int license, int nationalID, String location, int numOfSeats) {
        super(userName, mobileNum, email, password, birthdate);
        this.license = license;
        this.nationalID = nationalID;
        this.availableForRide = true;
        this.location = location;
        this.numOfSeats = numOfSeats;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAvailableForRide() {
        return availableForRide;
    }

    public void setAvailableForRide(boolean availableForRide) {
        this.availableForRide = availableForRide;
    }

    public ArrayList<String> getUserRating() { return userRating; }

    public ArrayList<String> getFavAreas() { return favAreas; }

    public ArrayList<String> getDriverNotifications() { return driverNotifications; }

    public ArrayList<Integer> getRatingList() { return ratingList; }

    public double getAvgRating() { return avgRating; }

    public void setAvgRating(double avg) { avgRating = avg; }

    public void calcAvgRating() {

        int sum = 0;
        int count = 0;
        for (int i = 0; i < getRatingList().size(); i++) {
            sum += getRatingList().get(i);
            count++;
        }
        setAvgRating(sum / count);
    }

}
