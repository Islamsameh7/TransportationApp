package com.company;

public class ClientControl implements ISubjectClient, IObserverClient {
    private Client c1;
    private Driver d1;
    private Data data = new Data();

    public ClientControl() {
    }

    public ClientControl(Client c1) {
        this.c1 = c1;
    }

    public void requestRide(String source, String destination){
        Ride ride = new Ride(source, destination, c1);
        data.getRides().add(ride);
        notify(source, destination);
    }

    @Override
    public void notify(String source , String destination) {
        for (Driver d: data.getDrivers()) {
            for (String ride: d.getFavAreas()){
                if (ride.equals(source)){
                    d.driverControl.update(source, destination);
                }
            }
        }
    }
}
