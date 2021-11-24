package com.company;

public class DriverRegister implements IRegister {

    @Override
    public void register(Data data, User user) {
        Driver driver = (Driver) user;
        data.getRequestedDrivers().add(driver);
    }
}