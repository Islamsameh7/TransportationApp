package com.company;

public class DriverAccount implements IAccount {

    @Override
    public User Login(Data data, String username, String pass) {
        for (int i=0 ; i<data.getDrivers().size() ; i++){
            if (username.equals(data.getDrivers().get(i).getUserName()))
                if (pass.equals(data.getDrivers().get(i).getPassword()))
                    return data.getDrivers().get(i);
        }
        return null;
    }

    @Override
    public void register(Data data, User user) {
        Driver driver = (Driver) user;
        data.getRequestedDrivers().add(driver);
    }
}
