package com.company;

public class Ride {

    Client client;
    Driver driver;
    private String source;
    private String destination;
    private boolean discount;

    public Ride(String source, String destination, Client client) {
        this.source = source;
        this.destination = destination;
        this.client = client;
        discount = false;
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
