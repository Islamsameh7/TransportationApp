package com.company.App;

import com.company.App.data.Data;
import com.company.App.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.company.App.data.Data.input;

public class DriverAccount implements IAccount {

    Data data;

    @Autowired
    public DriverAccount(@Qualifier("dataObj") Data data) {
        this.data = data;
    }

    @Override
    public Driver Login(String username, String pass) {
        for (int i = 0 ; i < data.getDrivers().size() ; i++){
            if (username.equals(data.getDrivers().get(i).getUserName()))
                if (pass.equals(data.getDrivers().get(i).getPassword()))
                    return data.getDrivers().get(i);
        }
        return null;
    }

    @Override
    public void register() throws ParseException {

        String userName, email = null, password, mobileNum, location, date;
        int license, id, numOfSeats;
        Date birthdate;

        System.out.println("Please enter your username");
        userName = input.next();
        System.out.println("Do you want to add an email?");
        System.out.println("1- Yes");
        System.out.println("2- No");
        int emailChoiceD = input.nextInt();
        switch (emailChoiceD){
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
        System.out.println("Please enter your license number");
        license = input.nextInt();
        System.out.println("Please enter your national id");
        id = input.nextInt();
        System.out.println("Please specify your location area");
        location = input.next();
        System.out.println("Please enter how many seats do you have?");
        numOfSeats = input.nextInt();
        data.getRequestedDrivers().add(new Driver(userName, mobileNum, email, password, birthdate, license, id, location, numOfSeats, data));
    }
}
