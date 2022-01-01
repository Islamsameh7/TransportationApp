package com.company.App.controller;

import com.company.App.model.Client;
import com.company.App.model.Driver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/controller/ride")
@RestController
public class RideControl {

    @GetMapping
    public void rideSimulation(Driver driver, Client client) throws InterruptedException {

        wait(3000);
        System.out.println("Driver: " + driver.getUserName() + " arrived at client: " + client.getUserName() + "'s location.");
        wait(3000);
        System.out.println("Driver: " + driver.getUserName() + " arrived to client: " + client.getUserName() + "'s destination.");

    }
}