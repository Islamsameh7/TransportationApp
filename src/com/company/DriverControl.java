package com.company;

public class DriverControl implements IObserverDriver, ISubjectDriver{

    private Driver driver;

    public DriverControl() {
    }

    public DriverControl(Driver driver) {
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void addArea(String areaName){
        driver.getFavAreas().add(areaName);
    }

    public void listAreas(){
        System.out.println("Your favourite areas: ");
        for (int i = 0; i < driver.getFavAreas().size(); i++){
            System.out.println(driver.getFavAreas().get(i));
        }
    }

    public void listRides(){
        int count = 0;
        System.out.println("Available rides: ");
        for (int i = 0; i < Main.data.getRides().size(); i++) {
                    System.out.println(i + 1 + ") Source: " + Main.data.getRides().get(i).getSource() + " | Destination: " + Main.data.getRides().get(i).getDestination());
                    count++;

        }
        if(count == 0)
            System.out.println("There is no rides available. ");
    }

    public void listUserRating() {
        System.out.println("User Ratings: ");
        for (int i = 0; i < driver.getUserRating().size(); i++) {
            System.out.println(driver.getUserRating().get(i));
        }
    }



    public void listNotifications(){
        for (String notification : driver.getDriverNotifications()) {
            System.out.println(notification);
        }
    }

    public void acceptRide(Ride ride, int offer){

        notify(ride, offer);
    }

    public void makeOffer(int offer, Client client){
        Main.data.getDriverOffer().add(offer);
    }

    @Override
    public void update(String src, String dst) {
        driver.getDriverNotifications().add("There is a new ride available: Source: " + src + " | Destination: " + dst);
    }

    @Override
    public void notify(Ride ride, int offer) {
        makeOffer(offer,ride.getClient());
    }
}
