package com.company;

import static com.company.Main.data;
import static com.company.Main.input;

public class AdminController {

    Admin admin;
    Suspend suspend;

    public AdminController() {
    }

    public AdminController(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void addDiscountArea(){
        System.out.println("Enter the area name: ");
        String area = input.next();
        data.getDiscountAreas().add(area);
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

    public void suspendUser(){
        System.out.println("1- Suspend a client.");
        System.out.println("2- Suspend a driver.");
        System.out.println("3- Back.");
        int suspendChoice = input.nextInt();
        switch (suspendChoice) {
            case 1:
                System.out.println("All clients: ");
                data.printClients();
                System.out.println("Choose the client number you want to suspend");
                int suspendClient = input.nextInt();
                suspend.clientSuspend(data.getClients().get(suspendClient - 1));
                break;
            case 2:
                System.out.println("All drivers: ");
                data.printDrivers();
                System.out.println("Choose the driver number you want to suspend");
                int suspendDriver = input.nextInt();
                suspend.driverSuspend(data.getDrivers().get(suspendDriver - 1));
                break;
            case 3:
                break;
            default:
                System.out.println("Wrong choice! ");
        }
    }
}
