package com.company;

public class Rating {

    public void rateDriver(Client client, Driver driver, int rate){
        driver.getRatingList().add(rate);
        driver.getUserRating().add(client.getUserName().toUpperCase() + ": " + String.valueOf(rate));
        driver.calcAvgRating();
    }
}
