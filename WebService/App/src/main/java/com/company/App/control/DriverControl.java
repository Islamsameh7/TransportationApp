package com.company.App.control;

import com.company.App.IObserverDriver;
import com.company.App.ISubjectDriver;
import com.company.App.model.Client;
import com.company.App.model.Driver;
import com.company.App.model.Ride;
import com.company.App.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverControl implements IObserverDriver, ISubjectDriver {
    DriverService driverService;

    @Autowired
    public DriverControl(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/driverControl/getDriver")
    public Driver getDriver() {
        return driverService.getDriver();
    }

    @PostMapping("/driverControl/setDrive")
    public void setDriver(Driver driver) {
        driverService.setDriver(driver);
    }

    @PostMapping("/driverControl/addFavArea")
    public void addFavArea(){
        driverService.addFavArea();
    }

    @GetMapping("/driverControl/listArea")
    public void listAreas(){
        driverService.listAreas();
    }

    @GetMapping("/driverControl/listAllRides")
    public void listAllRides(){
        driverService.listAllRides();
    }

    @GetMapping("/driverControl/listUserRating")
    public void listUserRating() {
        driverService.listUserRating();
    }

    @GetMapping("/driverControl/listNotifications")
    public void listNotifications(){
        driverService.listNotifications();
    }

    @GetMapping("/driverControl/acceptRide")
    public void acceptRide(){
        driverService.acceptRide();
    }

    @PutMapping("/driverControl/update")
    @Override
    public void update(String src, String dst, Client client) {
        driverService.update(src, dst, client);
    }

    @PutMapping("/driverControl/notify")
    @Override
    public void notify(Ride ride, double offer) {
        driverService.notify(ride, offer);
    }

    @PutMapping("/driverControl/changeLocation")
    public void changeLocation(){
        driverService.changeLocation();
    }

    @PutMapping("/driverControl/changeNumOfSeats")
    public void changeNumOfSeats(){
        driverService.changeNumOfSeats();
    }
}
