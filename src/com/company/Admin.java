package com.company;

public class Admin {

    private String username;
    private String password;

    public Admin(){
        username = "admin";
        password = "admin";
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void verify(Data data, Driver driver){
        data.getDrivers().add(driver);
        System.out.println(driver.getUserName().toUpperCase() + " is verified.");
        data.getRequestedDrivers().remove(driver);
    }

    public void listDriversRequests(Data data){
        System.out.println("Requested Drivers: ");
        for (int i = 0; i < data.getRequestedDrivers().size(); i++) {
            System.out.println(i+1 + ")" + data.getRequestedDrivers().get(i).getUserName());
        }
    }
}