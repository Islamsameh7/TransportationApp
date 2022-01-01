package com.company;

import java.util.ArrayList;

public class Driver extends User {

    private int license;
    private int nationalID;
    private ArrayList<String> userRating = new ArrayList<>();
    private ArrayList<Integer> ratingList = new ArrayList<>();
    private ArrayList<String> favAreas = new ArrayList<>();
    private ArrayList<String> driverNotifications = new ArrayList<>();
    private double avgRating;
    DriverControl driverControl= new DriverControl(this);
    private boolean availableForRide;

    public Driver(String userName, String mobileNum, String email, String password, int license, int nationalID) {
        super(userName, mobileNum, email, password);
        this.license = license;
        this.nationalID = nationalID;
        this.availableForRide = true;
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
