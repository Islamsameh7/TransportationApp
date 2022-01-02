package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.company.Main.*;

public class ClientControl implements ISubjectClient, IObserverClient {
    private Client client;
    private Rating rating = new Rating();
    private Driver rideDriver;

    public ClientControl() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientControl(Client client) {
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
        rideControl = new RideControl(ride);
        notify(source, destination, numOfPassengers);

    }

    @Override
    public void notify(String source, String destination, int numOfPassengers) {
        for (Driver driver : data.getDrivers()) {
            if (driver.isAvailableForRide() && driver.getLocation().equals(source) && driver.getNumOfSeats() >= numOfPassengers) {
                for (String ride : driver.getFavAreas()) {
                    if (ride.equals(source)) {
                        driver.driverControl.update(source, destination, this.getClient());
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
                rideControl.rideSimulation(this.getClient().getOfferdDrivers().get(offerChoice - 1), this.getClient());
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

