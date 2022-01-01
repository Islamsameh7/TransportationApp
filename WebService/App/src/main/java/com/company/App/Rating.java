package com.company.App;

import com.company.App.model.Client;
import com.company.App.model.Driver;

public class Rating {

    public void rateDriver(Client client, Driver driver, int rate){
        driver.getRatingList().add(rate);
        driver.getUserRating().add(client.getUserName().toUpperCase() + ": " + String.valueOf(rate));
        driver.calcAvgRating();
    }
}
