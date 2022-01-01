package com.company.App.controller;

import com.company.App.model.Admin;
import com.company.App.model.Driver;
import com.company.App.Suspend;
import com.company.App.data.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.company.App.data.Data.input;

@RequestMapping("/controller/admin")
@RestController
public class AdminControl {

    Admin admin;
    Suspend suspend;
    Data data;

    @Autowired
    public AdminControl(Data data) {
        this.data = data;
    }

    public AdminControl(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    @PostMapping
    public void addDiscountArea(){
        System.out.println("Enter the area name: ");
        String area = input.next();
        data.getDiscountAreas().add(area);
    }

    @PutMapping
    public void verify(Driver driver){
        data.getDrivers().add(driver);
        System.out.println(driver.getUserName().toUpperCase() + " is verified.");
        driver.setVerified(true);
        data.getRequestedDrivers().remove(driver);
    }

    @GetMapping
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

    @DeleteMapping
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
