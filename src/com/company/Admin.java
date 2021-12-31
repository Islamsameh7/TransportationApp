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

    public void verify(Driver driver){
        Main.data.getDrivers().add(driver);
        System.out.println(driver.getUserName().toUpperCase() + " is verified.");
        Main.data.getRequestedDrivers().remove(driver);
    }

    public void listDriversRequests(){
        int count = 0;
        System.out.println("Requested Drivers: ");
        for (int i = 0; i < Main.data.getRequestedDrivers().size(); i++) {
            System.out.println(i+1 + ")" + Main.data.getRequestedDrivers().get(i).getUserName());
            count++;
        }
        if (count==0)
            System.out.println("No available requests. ");
        else{
            System.out.println("Choose the driver number you want to verify");
            int verifyChoice = input.nextInt();
            verify(Main.data.getRequestedDrivers().get(verifyChoice - 1));
        }
    }
}
