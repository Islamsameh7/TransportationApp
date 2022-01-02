package com.company.App.service;


import com.company.App.Suspend;
import com.company.App.data.Data;
import com.company.App.model.Admin;
import com.company.App.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static com.company.App.data.Data.input;

@Service
public class AdminService {

    Data data;
    Admin admin;
    Suspend suspend;

    public AdminService() {
    }

    @Autowired
    public AdminService(@Qualifier("admin") Admin admin, @Qualifier("dataObj") Data data) {
        this.admin = admin;
        this.data = data;
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
        data.getDrivers().add(driver);
        System.out.println(driver.getUserName().toUpperCase() + " is verified.");
        data.getRequestedDrivers().remove(driver);
    }

    public void listDriversRequests(){
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
            verify(data.getRequestedDrivers().get(verifyChoice - 1));
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
    public void listEvents(){
        int count = 0;
        System.out.println("Events: ");
        for (int i = 0; i < data.getEvents().size(); i++) {
            System.out.println(i+1 + ")" + data.getEvents().get(i));
            count++;
        }
        if (count==0)
            System.out.println("No available events. ");
    }
}
