package com.company;

import java.util.Scanner;

public class Admin {

    private String username;
    private String password;
    Scanner input = new Scanner(System.in);

    public Admin(){
        username = "admin";
        password = "admin";
    }

    public String getUsername() { return username; }

    public String getPassword() {
        return password;
    }

    public void verify(Data data, Driver driver){
        data.getDrivers().add(driver);
        System.out.println(driver.getUserName().toUpperCase() + " is verified.");
        data.getRequestedDrivers().remove(driver);
    }

    public void listDriversRequests(Data data){
        int count = 0;
        System.out.println("Requested Drivers: ");
        for (int i = 0; i < data.getRequestedDrivers().size(); i++) {
            System.out.println(i+1 + ")" + data.getRequestedDrivers().get(i).getUserName());
            count++;
        }
        if (count==0)
            System.out.println("No available requests. ");
        else{
            System.out.println("Choose the driver number you want to verify");
            int verifyChoice = input.nextInt();
            verify(data, data.getRequestedDrivers().get(verifyChoice - 1));
        }
    }
}
