package com.company;

import static com.company.Main.input;
import static com.company.Main.data;

public class DriverAccount implements IAccount {

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
    public void register() {

        String userName;
        String email = null;
        String password;
        String mobileNum;
        int license;
        int id;

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
        System.out.println("Please enter your license number");
        license = input.nextInt();
        System.out.println("Please enter your national id");
        id = input.nextInt();
        data.getRequestedDrivers().add(new Driver(userName, mobileNum, email, password, license, id));
    }
}
