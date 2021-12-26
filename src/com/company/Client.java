package com.company;

public class Client extends User  {

    private String source;
    private String destination;


    public Client(String userName, String mobileNum, String email, String password) {
        super(userName, mobileNum, email, password);
    }

   /* public void requestRide(Data data, String source, String destination){
        Ride ride = new Ride(source, destination, this);
        data.getRides().add(ride);
        notify(data, source, destination);
    }

    @Override
    public void notify(Data data, String source , String destination) {
        for (Driver d: data.getDrivers()) {
            for (String ride: data.getFavAreas()){
                if (ride.equals(source)){
                    d.update(data, source, destination);
                }
            }
        }
    }*/

}
