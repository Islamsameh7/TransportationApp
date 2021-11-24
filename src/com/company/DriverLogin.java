package com.company;

public class DriverLogin implements ILogin {

    @Override
    public boolean Login(Data data, String username, String pass) {
        for (int i=0 ; i<data.getDrivers().size() ; i++){
            if (username.equals(data.getDrivers().get(i).getUserName()))
                if (pass.equals(data.getDrivers().get(i).getPassword()))
                    return true;
                else
                    return false;
            else
                return false;
        }
        return false;
    }
}
