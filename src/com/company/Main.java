package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Data data = new Data();
        DriverRegister dRegister = new DriverRegister();
        ClientRegister cRegister = new ClientRegister();
        DriverLogin dLogin = new DriverLogin();
        ClientLogin cLogin = new ClientLogin();
        Driver d1 = null;
        Client c1 = null;
        Admin admin = new Admin();
        Suspend suspend = new Suspend();
        Ride ride = null;
        Rating rating = new Rating();

        String userName;
        String email = null;
        String password;
        String mobileNum;
        int license;
        int id;
        String source;
        String destination;


        int mainChoice;
        Scanner input = new Scanner(System.in);
        mainMenu: while (true) {
            System.out.println("Hello, Choose a process: ");
            System.out.println("1- Register");
            System.out.println("2- Login");
            System.out.println("3- Admin page");
            System.out.println("4- Exit");
            mainChoice = input.nextInt();

            switch (mainChoice) {

                case 1: //IRegister

                    int subChoice1;
                    System.out.println("You are a: ");
                    System.out.println("1- Driver");
                    System.out.println("2- Client");
                    System.out.println("3- Back");
                    subChoice1 = input.nextInt();
                    switch (subChoice1) {

                        case 1: //Driver register

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
                            //Driver d1 = new Driver(userName, mobileNum, email, password, license, id);
                            d1 = new Driver(userName, mobileNum, email, password, license, id);
                            dRegister.register(data, d1);
                            break;

                        case 2: //Client register

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
                            //Client c1 = new Client(userName, mobileNum, email, password);
                            c1 = new Client(userName, mobileNum, email, password);
                            cRegister.register(data, c1);
                            break;

                        case 3:
                            continue mainMenu;

                        default:
                            System.out.println("Wrong choice, Choose again.");
                    }
                    break;

                case 2: //ILogin

                    int subChoice2;
                    System.out.println("You are a: ");
                    System.out.println("1- Driver");
                    System.out.println("2- Client");
                    System.out.println("3- Back");
                    subChoice2 = input.nextInt();
                    switch (subChoice2) {
                        case 1: //Driver
                            System.out.println("Please enter your username");
                            userName = input.next();
                            System.out.println("Please enter your password");
                            password = input.next();
                            while (true) {
                                if (dLogin.Login(data, userName, password)) {

                                    int dSubChoice;
                                    System.out.println("Welcome, " + d1.getUserName().toUpperCase());
                                    System.out.println("Your rating: " + d1.getAvgRating());
                                    System.out.println("--------------------------");
                                    System.out.println("1- Notifications.");
                                    System.out.println("2- Add an area to your favourite areas. ");
                                    System.out.println("3- List your favourite areas. ");
                                    System.out.println("4- List all user ratings ");
                                    System.out.println("5- List all rides.");
                                    System.out.println("6- logout.");
                                    dSubChoice = input.nextInt();

                                    switch (dSubChoice) {
                                        case 1:
                                            d1.listNotifications(data);
                                            break;

                                        case 2:
                                            System.out.println("Enter the area name: ");
                                            String area = input.next();
                                            d1.addArea(data, area);
                                            break;

                                        case 3:
                                            d1.listAreas(data);
                                            break;

                                        case 4:
                                            d1.listUserRating();
                                            break;

                                        case 5:
                                            d1.listRides(data);
                                            System.out.println("Do you want to accept any of them?");
                                            System.out.println("1- Yes");
                                            System.out.println("2- No");
                                            int notificationChoice = input.nextInt();
                                            switch (notificationChoice){
                                                case 1:
                                                    System.out.println("Choose the ride number you want to accept: ");
                                                    int rideChoice1 = input.nextInt();
                                                    System.out.println(rideChoice1 + ") Source: " + data.getRides().get(rideChoice1-1).getSource() + " | Destination: " + data.getRides().get(rideChoice1-1).getDestination());
                                                    System.out.println("Enter your offer: ");
                                                    int offer = input.nextInt();
                                                    d1.acceptRide(data, data.getRides().get(rideChoice1-1), offer);
                                                    break;

                                                case 2:
                                                    break;
                                            }
                                            break;

                                        case 6:
                                            continue mainMenu;

                                        default:
                                            System.out.println("Wrong choice, Choose again");
                                    }

                                } else {
                                    System.out.println("Wrong username or password.");
                                    break;
                                }
                            }


                        case 2: //Client

                            System.out.println("Please enter your username");
                            userName = input.next();
                            System.out.println("Please enter your password");
                            password = input.next();
                            while (true){
                                if (cLogin.Login(data, userName, password)) {
                                    int cSubChoice;
                                    System.out.println("Welcome, " + c1.getUserName().toUpperCase());
                                    System.out.println("--------------------------");
                                    System.out.println("1- Request a ride. ");
                                    System.out.println("2- Offers. ");
                                    System.out.println("3- Rate a driver. ");
                                    System.out.println("4- logout.");
                                    cSubChoice = input.nextInt();

                                    switch (cSubChoice) {
                                        case 1:
                                            System.out.println("Please enter source: ");
                                            source = input.next();
                                            System.out.println("Please enter your destination: ");
                                            destination = input.next();
                                            c1.requestRide(data,source,destination);
                                            //c1.notify(data, source, destination);
                                            break;

                                        case 2:
                                            System.out.println("The driver suggests: " + data.getDriverOffer().get(0));
                                            break;

                                        case 3:
                                            System.out.println("All drivers: ");
                                            data.printDrivers();
                                            System.out.println("Choose the driver number you want to rate: ");
                                            int rateChoice = input.nextInt();
                                            System.out.println(rateChoice + ") Driver name: " + data.getDrivers().get(rateChoice-1).getUserName() + " | Average rating: " + data.getDrivers().get(rateChoice-1).getAvgRating());
                                            while (true) {
                                                System.out.println("Enter your rate (From 1 to 5): ");
                                                int rate = input.nextInt();
                                                if (rate >= 1 && rate <= 5) {
                                                    rating.rateDriver(c1, data.getDrivers().get(rateChoice - 1), rate);
                                                    break;
                                                } else {
                                                    System.out.println("Please enter number between 1 and 5. ");
                                                }
                                            }

                                        case 4:
                                            continue mainMenu;

                                        default:
                                            System.out.println("Wrong choice, Choose again");
                                    }

                                }
                                else {
                                    System.out.println("Wrong username or password.");
                                    break;
                                }
                            }
                        case 3:
                            continue mainMenu;

                        default:
                            System.out.println("Wrong choice, Choose again");

                    }

                    break;

                case 3: //Admin username: admin , password: admin
                    System.out.println("Please enter your username");
                    userName = input.next();
                    System.out.println("Please enter your password");
                    password = input.next();
                    if (userName.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
                        while (true) {
                            int adminChoice;
                            System.out.println("Welcome, admin.");
                            System.out.println("1- List drivers requests.");
                            System.out.println("2- Suspend a user.");
                            System.out.println("3- Back to main menu");
                            adminChoice = input.nextInt();
                            switch (adminChoice) {
                                case 1:
                                    admin.listDriversRequests(data);
                                    break;

                                case 2:
                                    System.out.println("1- Suspend a client.");
                                    System.out.println("2- Suspend a driver.");
                                    System.out.println("3- Back.");
                                    int suspendChoice = input.nextInt();
                                    if (suspendChoice == 1) {
                                        System.out.println("All clients: ");
                                        data.printClients();
                                        System.out.println("Choose the client number you want to suspend");
                                        int suspendClient = input.nextInt();
                                        suspend.clientSuspend(data, data.getClients().get(suspendClient - 1));
                                    } else if (suspendChoice == 2) {
                                        System.out.println("All drivers: ");
                                        data.printDrivers();
                                        System.out.println("Choose the driver number you want to suspend");
                                        int suspendDriver = input.nextInt();
                                        suspend.driverSuspend(data, data.getDrivers().get(suspendDriver - 1));
                                    } else if (suspendChoice == 3) {
                                        break ;
                                    }
                                    break;

                                case 3:
                                    continue mainMenu;

                                default:
                                    System.out.println("Wrong choice, Choose again");
                                    break;
                            }
                        }
                    }
                    else{
                        System.out.println("Wrong username or password");
                        break;
                    }

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Wrong choice, Please choose a process");
                    break;
            }
        }
    }
}