package com.company.App.controller;

import com.company.App.IObserverClient;
import com.company.App.ISubjectClient;
import com.company.App.Rating;
import com.company.App.data.Data;
import com.company.App.model.Client;
import com.company.App.model.Driver;
import com.company.App.model.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.company.App.data.Data.input;

@RequestMapping("/controller/client")
@RestController
public class ClientControl implements ISubjectClient, IObserverClient {
    private Client client;
    private Data data;
    private Rating rating = new Rating();

    @Autowired
    public ClientControl(Data data) {
        this.data = data;
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

    @PostMapping
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

    @PutMapping
    @Override
    public void notify(String source , String destination) {
        for (Driver driver: data.getDrivers()) {
            if (driver.isAvailableForRide()) {
                for (String ride : driver.getFavAreas()) {
                    if (ride.equals(source)) {
                        driver.getDriverControl().update(source, destination);
                    }
                }
            }
        }
    }

    @PostMapping
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
    }

    @GetMapping
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

    @PutMapping
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
