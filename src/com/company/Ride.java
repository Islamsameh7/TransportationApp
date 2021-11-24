package com.company;

public class Ride {

    Client client;
    private String source;
    private String destination;

    public Ride(String source, String destination, Client client) {
        this.source = source;
        this.destination = destination;
        this.client = client;
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

    //    public void print(Ride ride){
//        System.out.println("Ride: (Source: " + ride.getSource() + ", Destination: " + ride.getDestination());
//    }
}
