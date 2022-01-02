package com.company.App;

import com.company.App.model.Client;

public interface IObserverDriver {

    void update(String src, String dst, Client client);
}
