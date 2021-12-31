package com.company;

public class ClientControl implements ISubjectClient, IObserverClient {
    private Client client;

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

    public void requestRide(String source, String destination){
        Ride ride = new Ride(source, destination, client);
        Main.data.getRides().add(ride);
        notify(source, destination);
    }

    @Override
    public void notify(String source , String destination) {
        for (Driver d: Main.data.getDrivers()) {
            for (String ride: d.getFavAreas()){
                if (ride.equals(source)){
                    d.driverControl.update(source, destination);
                }
            }
        }
    }
}
