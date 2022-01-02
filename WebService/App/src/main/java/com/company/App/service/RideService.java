package com.company.App.service;

import com.company.App.*;
import com.company.App.data.Data;
import com.company.App.model.Client;
import com.company.App.model.Driver;
import com.company.App.model.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class RideService {
    private Data data;
    private Ride ride;

    public RideService() {
    }

    @Autowired
    public RideService(Ride ride, @Qualifier("dataObj") Data data) {
        this.ride = ride;
        this.data = data;
    }

    public Ride getRide() {
        return ride;
    }

    public void checkDiscount() {
        if (ride.getClient().isFirstRide()){
            Discount discount = new FirstRideDiscount(new OriginalRidePrice());
            ride.setDiscountPrice(discount.makeDiscount(ride.getOriginalPrice(), ride.getDiscountPrice()));
            ride.setDiscount(true);
        }
        if (ride.getNumOfPassengers() == 2) {
            Discount discount = new TwoPassengersDiscount(new OriginalRidePrice());
            ride.setDiscountPrice(discount.makeDiscount(ride.getOriginalPrice(), ride.getDiscountPrice()));
            ride.setDiscount(true);
        }
        for (String area : data.getDiscountAreas()) {
            if (ride.getDestination().equals(area)) {
                Discount discount = new AdminAreaDiscount(new OriginalRidePrice());
                ride.setDiscountPrice(discount.makeDiscount(ride.getOriginalPrice(), ride.getDiscountPrice()));
                ride.setDiscount(true);
                break;
            }
        }
        for (Date date : data.getHolidays()){
            if (ride.getDate().equals(date)){
                Discount discount = new HolidayDiscount(new OriginalRidePrice());
                ride.setDiscountPrice(discount.makeDiscount(ride.getOriginalPrice(), ride.getDiscountPrice()));
                ride.setDiscount(true);
                break;
            }
        }
        if (ride.getClient().getBirthdate().equals(LocalDate.now())) {
            Discount discount = new BirthDateDiscount(new OriginalRidePrice());
            ride.setDiscountPrice(discount.makeDiscount(ride.getOriginalPrice(), ride.getDiscountPrice()));
            ride.setDiscount(true);
        }
    }

    public void rideSimulation(Driver driver, Client client) {

        System.out.println("Driver: " + driver.getUserName() + " arrived at client: " + client.getUserName() + "'s location.");

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        data.getEvents().add("Driver arrived at user location" + " | Driver: " + driver.getUserName() + " | Client: " + client.getUserName() + " | Date & Time: " + formattedDate);

        System.out.println("Driver: " + driver.getUserName() + " arrived to client: " + client.getUserName() + "'s destination.");

        myDateObj = LocalDateTime.now();
        myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy, HH:mm:ss");
        formattedDate = myDateObj.format(myFormatObj);

        data.getEvents().add("Driver arrived at user destination" + " | Driver: " + driver.getUserName() + " | Client: " + client.getUserName() + " | Date & Time: " + formattedDate);

        driver.setBalance(ride.getOriginalPrice());
        driver.setAvailableForRide(true);
    }
}