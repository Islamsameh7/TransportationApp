package com.company.App.service;

import com.company.App.IObserverClient;
import com.company.App.ISubjectClient;
import com.company.App.Rating;
import com.company.App.data.Data;
import com.company.App.model.Client;
import com.company.App.model.Driver;
import com.company.App.model.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.company.App.data.Data.input;

@Service
public class ClientService implements ISubjectClient, IObserverClient {

    private Client client;
    private Rating rating = new Rating();
    private Driver rideDriver;
    private Data data;
    private RideService rideService;

    @Autowired
    public ClientService(Client client, @Qualifier("dataObj") Data data) {
        this.data = data;
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Driver getRideDriver() {
        return rideDriver;
    }

    public void setRideDriver(Driver rideDriver) {
        this.rideDriver = rideDriver;
    }

    public void requestRide() {

        System.out.println("Please enter source: ");
        String source = input.next();
        System.out.println("Please enter your destination: ");
        String destination = input.next();
        System.out.println("Please enter number of passengers: ");
        int numOfPassengers = input.nextInt();

        Ride ride = new Ride(source, destination, client, numOfPassengers);
        data.getRides().add(ride);
        rideService = new RideService(ride, data);
        notify(source, destination, numOfPassengers);

    }

    @Override
    public void notify(String source, String destination, int numOfPassengers) {
        for (Driver driver : data.getDrivers()) {
            if (driver.isAvailableForRide() && driver.getLocation().equals(source) && driver.getNumOfSeats() >= numOfPassengers) {
                for (String ride : driver.getFavAreas()) {
                    if (ride.equals(source)) {
                        driver.getDriverControl().update(source, destination, this.getClient());
                        break;
                    }
                }
            }
        }
    }

    public void listAllOffers() {
        int count = 0;
        System.out.println("Available offers: ");
        for (String offer : client.getDriversOffers()) {
            count++;
            System.out.println(count + ") " + offer);

        }
        if (count == 0)
            System.out.println("There is no offers available. ");
    }

    public void rateDriver() {
        System.out.println("All drivers: ");
        data.printDrivers();
        System.out.println("Choose the driver number you want to rate: ");
        int rateChoice = input.nextInt();
        System.out.println(rateChoice + ") Driver name: " + data.getDrivers().get(rateChoice - 1).getUserName() +
                " | Average rating: " + data.getDrivers().get(rateChoice - 1).getAvgRating());
        while (true) {
            System.out.println("Enter your rate (From 1 to 5): ");
            int rate = input.nextInt();
            if (rate >= 1 && rate <= 5) {
                rating.rateDriver(this.getClient(), data.getDrivers().get(rateChoice - 1), rate);
                break;
            } else {
                System.out.println("Please enter number between 1 and 5. ");
            }
        }
    }

    @Override
    public void update(double offer, Ride ride, Driver driver) {
        if (ride.isDiscount()) {
            ride.getClient().getDriversOffers().add(
                    "Driver: " + driver.getUserName() +
                            " | Original price: " + offer +
                            " | Price after discount: " + offer * 0.9 +
                            " | Ride details: Source: " + ride.getSource() +
                            " Destination: " + ride.getDestination());
            ride.getClient().getOfferdDrivers().add(ride.getClient().getDriversOffers().size() - 1, driver);
        } else {
            ride.getClient().getDriversOffers().add(
                    "Driver: " + driver.getUserName() +
                            " | Price: " + offer +
                            " | Ride details: Source: " + ride.getSource() +
                            " Destination: " + ride.getDestination());
            ride.getClient().getOfferdDrivers().add(ride.getClient().getDriversOffers().size() - 1, driver);
        }

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        data.getEvents().add("New offer " + " | Driver: " + driver.getUserName() + " | Date & Time: " + formattedDate + " | Offer: " + offer);
    }

    public void acceptOffer() throws InterruptedException {
        System.out.println("Do you want to accept any of them?");
        System.out.println("1- Yes");
        System.out.println("2- No");
        int notificationChoice = input.nextInt();
        switch (notificationChoice) {
            case 1:
                System.out.println("Choose the offer number you want to accept: ");
                int offerChoice = input.nextInt();
                System.out.println(offerChoice + ") " + client.getDriversOffers().get(offerChoice - 1));
                this.getClient().setFirstRide(false);
                rideService.rideSimulation(this.getClient().getOfferdDrivers().get(offerChoice - 1), this.getClient());
                break;

            case 2:
                break;

            default:
                System.out.println("Wrong choice!");
        }

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        data.getEvents().add("Offer Accepted " + " | Client: " + this.getClient().getUserName() + " | Date & Time: " + formattedDate);
    }
}

