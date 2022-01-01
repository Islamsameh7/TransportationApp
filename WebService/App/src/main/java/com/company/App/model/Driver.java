package com.company.App.model;
import com.company.App.controller.DriverControl;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Driver extends User {

    private int license;
    private int nationalID;
    private ArrayList<String> userRating = new ArrayList<>();
    private ArrayList<Integer> ratingList = new ArrayList<>();
    private ArrayList<String> favAreas = new ArrayList<>();
    private ArrayList<String> driverNotifications = new ArrayList<>();
    private DriverControl driverControl = new DriverControl(this);
    private double avgRating;
    private boolean availableForRide;
    private boolean verified;

    public Driver(@JsonProperty("username") String userName,
                  @JsonProperty("mobile") String mobileNum,
                  @JsonProperty("email") String email,
                  @JsonProperty("password") String password,
                  @JsonProperty("license") int license,
                  @JsonProperty("nationalID") int nationalID) {
        super(userName, mobileNum, email, password);
        this.license = license;
        this.nationalID = nationalID;
        this.availableForRide = true;
        this.verified = false;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public DriverControl getDriverControl() {
        return driverControl;
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
