package com.company;

import java.util.ArrayList;

public class Driver extends User  {

    private int license;
    private int nationalID;
    private ArrayList<String> userRating = new ArrayList<>();
    private ArrayList<Integer> ratingList = new ArrayList<>();
    private ArrayList<String> favAreas = new ArrayList<>();
    private ArrayList<String> driverNotifications = new ArrayList<>();
    private double avgRating;
    DriverControl driverControl= new DriverControl(this);

    public Driver(String userName, String mobileNum, String email, String password, int license, int nationalID) {
        super(userName, mobileNum, email, password);
        this.license = license;
        this.nationalID = nationalID;
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

    /*public void addArea(Data data, String areaName){
        data.getFavAreas().add(areaName);
    }

    public void listAreas(Data data){
        System.out.println("Your favourite areas: ");
        for (int i = 0; i < data.getFavAreas().size(); i++){
            System.out.println(data.getFavAreas().get(i));
        }
    }

    public void listRides(Data data){
        int count = 0;
        System.out.println("Available rides: ");
        for (int i = 0; i < data.getRides().size(); i++) {
            for (int j = 0; j < data.getFavAreas().size(); j++) {
                if (data.getRides().get(i).getSource().equals(data.getFavAreas().get(j))) {
                    System.out.println(i + 1 + ") Source: " + data.getRides().get(i).getSource() + " | Destination: " + data.getRides().get(i).getDestination());
                    count++;
                }
            }
        }
        if(count == 0)
            System.out.println("There is no rides available. ");
    }

    public void listUserRating() {
        System.out.println("User Ratings: ");
        for (int i = 0; i < getUserRating().size(); i++) {
            System.out.println(getUserRating().get(i));
        }
    }

    public void calcAvgRating() {

        int sum = 0;
        int count = 0;
        for (int i = 0; i < getRatingList().size(); i++) {
            sum += getRatingList().get(i);
            count++;
        }
        avgRating = sum / count;
    }

    public double getAvgRating(){ return avgRating; }

    public void listNotifications(Data data){
        for (String notification : data.getDriverNotifications()) {
            System.out.println(notification);
        }
    }

    public void acceptRide(Data data, Ride ride, int offer){

        notify(data, ride, offer);
    }

    public void makeOffer(Data data, int offer, Client client){
        data.getDriverOffer().add(offer);
    }

    @Override
    public void update(Data data, String src, String dst) {
        data.getDriverNotifications().add("There is a new ride available: Source: " + src + " | Destination: " + dst);
    }

    @Override
    public void notify(Data data, Ride ride, int offer) {
        makeOffer(data, offer,ride.getClient());
    }*/
}
