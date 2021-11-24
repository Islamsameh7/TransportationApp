package com.company;

public class ClientLogin implements ILogin {

    @Override
    public boolean Login(Data data, String username, String pass) {
        for (int i=0 ; i<data.getClients().size() ; i++){
            if (username.equals(data.getClients().get(i).getUserName()))
                if (pass.equals(data.getClients().get(i).getPassword()))
                    return true;
                else
                    return false;
            else
                return false;
        }
        return false;
    }
}
