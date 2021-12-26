package com.company;

public class ClientAccount implements IAccount {

    @Override
    public boolean Login(Data data, String username, String pass) {
        for (int i=0 ; i<data.getClients().size() ; i++){
            if (username.equals(data.getClients().get(i).getUserName()))
                if (pass.equals(data.getClients().get(i).getPassword()))
                    return true;
        }
        return false;
    }

    @Override
    public void register(Data data, User user) {
        Client client = (Client) user;
        data.getClients().add(client);

    }
}
