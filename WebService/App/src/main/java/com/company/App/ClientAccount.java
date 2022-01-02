package com.company.App;

import com.company.App.data.Data;
import com.company.App.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.company.App.data.Data.input;

public class ClientAccount implements IAccount {

    Data data;

    @Autowired
    public ClientAccount(@Qualifier("dataObj") Data data) {
        this.data = data;
    }

    @Override
    public Client Login(String username, String pass) {
        for (int i=0 ; i<data.getClients().size() ; i++){
            if (username.equals(data.getClients().get(i).getUserName()))
                if (pass.equals(data.getClients().get(i).getPassword()))
                    return data.getClients().get(i);
        }
        return null;
    }

    @Override
    public void register() throws ParseException {

        String userName;
        String email = null;
        String password;
        String mobileNum;
        String date;
        Date birthdate;

        System.out.println("Please enter your username");
        userName = input.next();
        System.out.println("Do you want to add an email?");
        System.out.println("1- Yes");
        System.out.println("2- No");
        int emailChoiceC = input.nextInt();
        switch (emailChoiceC){
            case 1:
                System.out.println("Please enter your email");
                email = input.next();
                break;

            case 2:
                email = "No email.";
                break;
        }
        System.out.println("Please enter your password");
        password = input.next();
        System.out.println("Please enter your mobile number");
        mobileNum = input.next();
        System.out.println("Please enter your birth date (dd/MM/yyyy)");
        date = input.next();
        birthdate = new SimpleDateFormat(date).parse(date);
        data.getClients().add(new Client(userName, mobileNum, email, password, birthdate, data));

    }
}
