package com.company;

public class Suspend {

    public void clientSuspend(Data data, Client client){
        data.getClients().remove(client);
        System.out.println(client.getUserName() + " is suspended.");
    }

    public void driverSuspend(Data data, Driver driver){
        data.getDrivers().remove(driver);
        System.out.println(driver.getUserName() + " is suspended.");
    }
}
