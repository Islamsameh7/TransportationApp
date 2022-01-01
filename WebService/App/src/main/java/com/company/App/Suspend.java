package com.company.App;

import com.company.App.data.Data;
import com.company.App.model.Client;
import com.company.App.model.Driver;

public class Suspend {

    Data data;

    public Suspend(Data data) {
        this.data = data;
    }

    public void clientSuspend(Client client){
        data.getClients().remove(client);
        System.out.println(client.getUserName() + " is suspended.");
    }

    public void driverSuspend(Driver driver){
        data.getDrivers().remove(driver);
        System.out.println(driver.getUserName() + " is suspended.");
    }

}
