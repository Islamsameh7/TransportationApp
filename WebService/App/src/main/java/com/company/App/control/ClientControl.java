package com.company.App.control;

import com.company.App.IObserverClient;
import com.company.App.ISubjectClient;
import com.company.App.model.Client;
import com.company.App.model.Driver;
import com.company.App.model.Ride;
import com.company.App.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientControl implements ISubjectClient, IObserverClient {
    ClientService clientService;

    @Autowired
    public ClientControl(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clientControl/getClient")
    public Client getClient() {
        return clientService.getClient();
    }

    @PostMapping("/clientControl/setClient")
    public void setClient(Client client) {
        clientService.setClient(client);
    }

    @GetMapping("/clientControl/getRideDriver")
    public Driver getRideDriver() {
        return clientService.getRideDriver();
    }

    @PostMapping("/clientControl/setRideDriver")
    public void setRideDriver(Driver rideDriver) {
        clientService.setRideDriver(rideDriver);
    }

    @PostMapping("/clientControl/requestRide")
    public void requestRide() {
        clientService.requestRide();
    }

    @PutMapping("/clientControl/notify")
    @Override
    public void notify(String source, String destination, int numOfPassengers) {
        clientService.notify(source, destination, numOfPassengers);
    }

    @PutMapping("/clientControl/rateDriver")
    public void rateDriver() {
        clientService.rateDriver();
    }

    @PutMapping("/clientControl/update")
    @Override
    public void update(double offer, Ride ride, Driver driver) {
        clientService.update(offer, ride, driver);
    }

    @GetMapping("/clientControl/acceptOffer")
    public void acceptOffer() throws InterruptedException {
        clientService.acceptOffer();
    }
}
