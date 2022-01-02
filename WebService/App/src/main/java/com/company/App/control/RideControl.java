package com.company.App.control;

import com.company.App.model.Client;
import com.company.App.model.Driver;
import com.company.App.model.Ride;
import com.company.App.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RideControl {
    RideService rideService;

    @Autowired
    public RideControl(RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping("/rideControl/getRide")
    public Ride getRide() {
        return rideService.getRide();
    }

    @PutMapping("/rideControl/checkDiscount")
    public void checkDiscount() {
        rideService.checkDiscount();
    }

    @GetMapping("/rideControl/rideSimulation")
    public void rideSimulation(Driver driver, Client client) {
        rideService.rideSimulation(driver, client);
    }
}
