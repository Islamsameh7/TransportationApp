package com.company;

public class Suspend {

    public void clientSuspend(Client client){
        Main.data.getClients().remove(client);
        System.out.println(client.getUserName() + " is suspended.");
    }

    public void driverSuspend(Driver driver){
        Main.data.getDrivers().remove(driver);
        System.out.println(driver.getUserName() + " is suspended.");
    }

}
