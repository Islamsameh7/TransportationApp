package com.company;

public class DriverControl implements IObserverDriver, ISubjectDriver{

   private Data data = new Data();
   private Driver d1;
    private Client c1;

    public DriverControl() {
    }

    public DriverControl(Driver d1) {
        this.d1 = d1;
    }

    public void addArea(String areaName){
        d1.getFavAreas().add(areaName);
    }

    public void listAreas(){
        System.out.println("Your favourite areas: ");
        for (int i = 0; i < d1.getFavAreas().size(); i++){
            System.out.println(d1.getFavAreas().get(i));
        }
    }

    public void listRides(){
        int count = 0;
        System.out.println("Available rides: ");
        for (int i = 0; i < data.getRides().size(); i++) {
           // for (int j = 0; j < d1.getFavAreas().size(); j++) {
                //if (data.getRides().get(i).getSource().equals(d1.getFavAreas().get(j))) {
                    System.out.println(i + 1 + ") Source: " + data.getRides().get(i).getSource() + " | Destination: " + data.getRides().get(i).getDestination());
                    count++;


        }
        if(count == 0)
            System.out.println("There is no rides available. ");
    }

    public void listUserRating() {
        System.out.println("User Ratings: ");
        for (int i = 0; i < d1.getUserRating().size(); i++) {
            System.out.println(d1.getUserRating().get(i));
        }
    }



    public void listNotifications(){
        for (String notification : d1.getDriverNotifications()) {
            System.out.println(notification);
        }
    }

    public void acceptRide(Ride ride, int offer){

        notify(ride, offer);
    }

    public void makeOffer(int offer, Client client){
        data.getDriverOffer().add(offer);
    }

    @Override
    public void update(String src, String dst) {
        d1.getDriverNotifications().add("There is a new ride available: Source: " + src + " | Destination: " + dst);
    }

    @Override
    public void notify(Ride ride, int offer) {
        makeOffer(offer,ride.getClient());
    }
}
