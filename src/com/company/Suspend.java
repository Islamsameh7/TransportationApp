package com.company;

public class Suspend {

    public static void clientSuspend(Client client){
        Main.data.getClients().remove(client);
        System.out.println(client.getUserName() + " is suspended.");
    }

    public static void driverSuspend(Driver driver){
        Main.data.getDrivers().remove(driver);
        System.out.println(driver.getUserName() + " is suspended.");
    }

}
