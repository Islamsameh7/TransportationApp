package com.company;

import java.util.Scanner;

public class Main {

    public static Data data = new Data();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        DriverAccount driverAccount = new DriverAccount();
        ClientAccount clientAccount = new ClientAccount();
        DriverControl driverControl;
        ClientControl clientControl;
        Admin admin = new Admin();
        Suspend suspend = new Suspend();
        Rating rating = new Rating();

        String userName;
        String password;

        int mainChoice;
        mainMenu: while (true) {
            System.out.println("Hello, Choose a process: ");
            System.out.println("1- Register");
            System.out.println("2- Login");
            System.out.println("3- Admin page");
            System.out.println("4- Exit");
            mainChoice = input.nextInt();

            switch (mainChoice) {

                case 1: //Register

                    int subChoice1;
                    System.out.println("You are a: ");
                    System.out.println("1- Driver");
                    System.out.println("2- Client");
                    System.out.println("3- Back");
                    subChoice1 = input.nextInt();
                    switch (subChoice1) {

                        case 1: //Driver register

                            driverAccount.register();
                            break;

                        case 2: //Client register

                            clientAccount.register();
                            break;

                        case 3:
                            continue mainMenu;

                        default:
                            System.out.println("Wrong choice, Choose again.");
                    }
                    break;

                case 2: //Login

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
                                if (driverAccount.Login(userName, password)!= null) {
                                    driverControl = new DriverControl(driverAccount.Login(userName, password));
                                    int dSubChoice;
                                    System.out.println("Welcome, " + driverControl.getDriver().getUserName().toUpperCase());
                                    System.out.println("Your rating: " + driverControl.getDriver().getAvgRating());
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
                                            driverControl.listNotifications();
                                            break;

                                        case 2:
                                            driverControl.addFavArea();
                                            break;

                                        case 3:
                                            driverControl.listAreas();
                                            break;

                                        case 4:
                                            driverControl.listUserRating();
                                            break;

                                        case 5:
                                            driverControl.listRides();
                                            driverControl.acceptRide();
//                                            System.out.println("Do you want to accept any of them?");
//                                            System.out.println("1- Yes");
//                                            System.out.println("2- No");
//                                            int notificationChoice = input.nextInt();
//                                            switch (notificationChoice){
//                                                case 1:
//                                                    System.out.println("Choose the ride number you want to accept: ");
//                                                    int rideChoice1 = input.nextInt();
//                                                    System.out.println(rideChoice1 + ") Source: " + data.getRides().get(rideChoice1-1).getSource() + " | Destination: " + data.getRides().get(rideChoice1-1).getDestination());
//                                                    System.out.println("Enter your offer: ");
//                                                    int offer = input.nextInt();
//                                                    driverControl.acceptRide(data.getRides().get(rideChoice1-1), offer);
//                                                    break;
//
//                                                case 2:
//                                                    break;
//                                            }
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
                                if (clientAccount.Login(userName, password)!= null) {
                                    clientControl = new ClientControl(clientAccount.Login(userName, password));
                                    int cSubChoice;
                                    System.out.println("Welcome, " + clientAccount.Login(userName, password).getUserName().toUpperCase());
                                    System.out.println("--------------------------");
                                    System.out.println("1- Request a ride. ");
                                    System.out.println("2- Offers. ");
                                    System.out.println("3- Rate a driver. ");
                                    System.out.println("4- logout.");
                                    cSubChoice = input.nextInt();

                                    switch (cSubChoice) {
                                        case 1:
                                            clientControl.requestRide();
                                            break;

                                        case 2:
                                            clientControl.listAllOffers();
                                            clientControl.acceptOffer();
                                            break;

                                        case 3:
                                            clientControl.rateDriver();
                                            break;

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
                            System.out.println("2- List events.");
                            System.out.println("3- Suspend a user.");
                            System.out.println("4- Add area to the discount areas. ");
                            System.out.println("5- Back to main menu");
                            adminChoice = input.nextInt();
                            switch (adminChoice) {
                                case 1:
                                    admin.listDriversRequests();
                                    break;
                                case 2:
                                    admin.listEvents();
                                    break;
                                case 3:
                                    System.out.println("1- Suspend a client.");
                                    System.out.println("2- Suspend a driver.");
                                    System.out.println("3- Back.");
                                    int suspendChoice = input.nextInt();
                                    if (suspendChoice == 1) {
                                        System.out.println("All clients: ");
                                        data.printClients();
                                        System.out.println("Choose the client number you want to suspend");
                                        int suspendClient = input.nextInt();
                                        suspend.clientSuspend(data.getClients().get(suspendClient - 1));
                                    } else if (suspendChoice == 2) {
                                        System.out.println("All drivers: ");
                                        data.printDrivers();
                                        System.out.println("Choose the driver number you want to suspend");
                                        int suspendDriver = input.nextInt();
                                        suspend.driverSuspend(data.getDrivers().get(suspendDriver - 1));
                                    } else if (suspendChoice == 3) {
                                        break ;
                                    }
                                    break;
                                case 4:
                                    admin.addDiscountArea();
                                    break;
                                case 5:
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