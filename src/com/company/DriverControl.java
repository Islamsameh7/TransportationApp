package com.company;

import static com.company.Main.input;
import static com.company.Main.data;

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

    public void addFavArea(){
        System.out.println("Enter the area name: ");
        String area = input.next();
        driver.getFavAreas().add(area);
    }

    public void listAreas(){
        System.out.println("Your favourite areas: ");
        for (int i = 0; i < driver.getFavAreas().size(); i++){
            System.out.println(driver.getFavAreas().get(i));
        }
    }

    public void listAllRides(){
        int count = 0;
        System.out.println("Available rides: ");
        for (int i = 0; i < data.getRides().size(); i++) {
                    System.out.println(i + 1 + ") Source: " + data.getRides().get(i).getSource() + " | Destination: " + data.getRides().get(i).getDestination());
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

    public void acceptRide(){
        System.out.println("Do you want to accept any of them?");
        System.out.println("1- Yes");
        System.out.println("2- No");
        int notificationChoice = input.nextInt();
        switch (notificationChoice){
            case 1:
                System.out.println("Choose the ride number you want to accept: ");
                int rideChoice1 = input.nextInt();
                System.out.println(rideChoice1 + ") Source: " + data.getRides().get(rideChoice1-1).getSource() + " | Destination: " + data.getRides().get(rideChoice1-1).getDestination());
                System.out.println("Enter your offer: ");
                int offer = input.nextInt();
                notify(data.getRides().get(rideChoice1-1), offer);
                break;

            case 2:
                break;

            default:
                System.out.println("Wrong choice! ");
        }
    }

    public void makeOffer(int offer, Ride ride) {
        if (ride.isDiscount()) {
            ride.getClient().getDriversOffers().add(
                    "Driver: " + this.getDriver().getUserName() +
                    " | Original price: " + offer +
                    " | Price after discount: " + offer * 0.9 +
                    " | Ride details: Source: " + ride.getSource() +
                    " Destination: " + ride.getDestination());
            ride.getClient().getOfferdDrivers().add(ride.getClient().getDriversOffers().size()-1, this.getDriver());

        } else{
            ride.getClient().getDriversOffers().add(
                    "Driver: " + this.getDriver().getUserName() +
                    " | Price: " + offer +
                    " | Ride details: Source: " + ride.getSource() +
                    " Destination: " + ride.getDestination());
            ride.getClient().getOfferdDrivers().add(ride.getClient().getDriversOffers().size()-1, this.getDriver());
        }
    }

    @Override
    public void update(String src, String dst) {
        driver.getDriverNotifications().add("There is a new ride available: Source: " + src + " | Destination: " + dst);
    }

    @Override
    public void notify(Ride ride, int offer) {
        makeOffer(offer, ride);
    }
}
