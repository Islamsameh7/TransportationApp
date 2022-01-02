package com.company.App.service;

import com.company.App.IObserverDriver;
import com.company.App.ISubjectDriver;
import com.company.App.data.Data;
import com.company.App.model.Client;
import com.company.App.model.Driver;
import com.company.App.model.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static com.company.App.data.Data.input;

@Service
public class DriverService implements IObserverDriver,ISubjectDriver {

    private Data data;
    private Driver driver;
    private RideService rideService;

    public DriverService() {
    }

    @Autowired
    public DriverService(Driver driver, @Qualifier("dataObj") Data data) {
        this.driver = driver;
        this.data = data;
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
                double offer = input.nextInt();
                data.getRides().get(rideChoice1-1).setOriginalPrice(offer);
                notify(data.getRides().get(rideChoice1-1), offer);
                break;

            case 2:
                break;

            default:
                System.out.println("Wrong choice! ");
        }
    }

    public void makeOffer(double offer, Ride ride) {
        rideService = new RideService(ride, data);
        rideService.checkDiscount();
        ride.getOffers().add(offer);
        ride.getClient().getClientControl().update(offer, ride, this.getDriver());
    }

    @Override
    public void update(String src, String dst, Client client) {
        driver.getDriverNotifications().add("There is a new ride available: Source: " + src + " | Destination: " + dst + " | Client: " + client.getUserName());
    }

    @Override
    public void notify(Ride ride, double offer) {
        makeOffer(offer, ride);
    }

    public void changeLocation(){
        System.out.println("Enter your location");
        driver.setLocation(input.next());
    }

    public void changeNumOfSeats(){
        System.out.println("Enter number of seats.");
        driver.setNumOfSeats(input.nextInt());
    }
}