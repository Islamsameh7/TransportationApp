package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.company.Main.data;
import static com.company.Main.input;

public class ClientControl implements ISubjectClient, IObserverClient {
    private Client client;
    private Rating rating = new Rating();

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

    public void requestRide(){

        System.out.println("Please enter source: ");
        String source = input.next();
        System.out.println("Please enter your destination: ");
        String destination = input.next();
        Ride ride = new Ride(source, destination, client);
        for (String area: data.getDiscountAreas()){
            if (destination.equals(area)){
                System.out.println("10% discount applied on this trip.");
                ride.setDiscount(true);
                break;
            }
        }
        data.getRides().add(ride);
        notify(source, destination);

    }

    @Override
    public void notify(String source , String destination) {
        for (Driver driver: data.getDrivers()) {
            if (driver.isAvailableForRide()) {
                for (String ride : driver.getFavAreas()) {
                    if (ride.equals(source)) {
                        driver.driverControl.update(source, destination);
                    }
                }
            }
        }
    }

    public void acceptOffer(){
        System.out.println("Do you want to accept any of them?");
        System.out.println("1- Yes");
        System.out.println("2- No");
        int notificationChoice = input.nextInt();
        switch (notificationChoice){
            case 1:
                System.out.println("Choose the offer number you want to accept: ");
                int offerChoice = input.nextInt();
                System.out.println(offerChoice + ") " + client.getDriversOffers().get(offerChoice - 1));
                break;
            case 2:
                break;
        }

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        data.getEvents().add("Offer Accepted " + " | Client: " + this.getClient().getUserName() + " | Date & Time: " + formattedDate);
    }

    public void listAllOffers(){
        int count = 0;
        System.out.println("Available offers: ");
        for (String offer : client.getDriversOffers()) {
            count++;
            System.out.println(count + ") " + offer);

        }
        if(count == 0)
            System.out.println("There is no offers available. ");
    }

    public void rateDriver(){
        System.out.println("All drivers: ");
        data.printDrivers();
        System.out.println("Choose the driver number you want to rate: ");
        int rateChoice = input.nextInt();
        System.out.println(rateChoice + ") Driver name: " + data.getDrivers().get(rateChoice-1).getUserName() +
                " | Average rating: " + data.getDrivers().get(rateChoice-1).getAvgRating());
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
}
