package com.company.App;

import com.company.App.data.Data;
import com.company.App.model.Client;
import com.company.App.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Suspend {
    Data data;

    @Autowired
    public Suspend(@Qualifier("dataObj") Data data) {
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
