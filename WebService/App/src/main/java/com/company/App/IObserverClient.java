package com.company.App;

import com.company.App.model.Driver;
import com.company.App.model.Ride;

public interface IObserverClient {

    public void update(double offer, Ride ride, Driver driver);
}