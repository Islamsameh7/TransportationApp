package com.company;

public class ClientRegister implements IRegister {

    @Override
    public void register(Data data, User user) {
        Client client = (Client) user;
        data.getClients().add(client);

    }
}
