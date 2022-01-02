package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Ride {

    Client client;
    Driver driver;
    private Date date;
    private int numOfPassengers;
    private double originalPrice;
    private double discountPrice;
    private String source;
    private String destination;
    private boolean discount;
    private ArrayList<Double> offers = new ArrayList<>();

    public Ride(String source, String destination, Client client, int numOfPassengers) {
        this.source = source;
        this.destination = destination;
        this.client = client;
        this.numOfPassengers = numOfPassengers;
        discount = false;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Double> getOffers() {
        return offers;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.discountPrice = originalPrice;
        this.originalPrice = originalPrice;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setClient(Client client) { this.client = client; }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Client getClient() { return client; }

}
