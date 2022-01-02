package com.company;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static Data data = new Data();
    public static Scanner input = new Scanner(System.in);
    public static RideControl rideControl;

    public static void main(String[] args) throws ParseException, InterruptedException {
        DriverAccount driverAccount = new DriverAccount();
        ClientAccount clientAccount = new ClientAccount();
        AdminControl adminControl = new AdminControl(new Admin());
        DriverControl driverControl;
        ClientControl clientControl;

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

            try {
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
                                    if (driverAccount.Login(userName, password) != null) {
                                        driverControl = new DriverControl(driverAccount.Login(userName, password));
                                        int dSubChoice;
                                        System.out.println("Welcome, " + driverControl.getDriver().getUserName().toUpperCase());
                                        System.out.println("Your rating: " + driverControl.getDriver().getAvgRating());
                                        System.out.println("Your current location: " + driverControl.getDriver().getLocation());
                                        System.out.println("--------------------------");
                                        System.out.println("1- Notifications.");
                                        System.out.println("2- Add an area to your favourite areas. ");
                                        System.out.println("3- List your favourite areas. ");
                                        System.out.println("4- Change your location. ");
                                        System.out.println("5- List all user ratings. ");
                                        System.out.println("6- List all rides.");
                                        System.out.println("7- logout.");
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
                                                driverControl.changeLocation();
                                                break;

                                            case 5:
                                                driverControl.listUserRating();
                                                break;

                                            case 6:
                                                driverControl.listAllRides();
                                                driverControl.acceptRide();
                                                break;

                                            case 7:
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
                                while (true) {
                                    if (clientAccount.Login(userName, password) != null) {
                                        clientControl = new ClientControl(clientAccount.Login(userName, password));
                                        int cSubChoice;
                                        System.out.println("Welcome, " + clientAccount.Login(userName, password).getUserName().toUpperCase());
                                        System.out.println("--------------------------");
                                        System.out.println("1- Request a ride. ");
                                        System.out.println("2- Offers for your requested ride. ");
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

                                    } else {
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
                        if (userName.equals(adminControl.getAdmin().getUsername()) && password.equals(adminControl.getAdmin().getPassword())) {
                            while (true) {
                                int adminChoice;
                                System.out.println("Welcome, admin.");
                                System.out.println("1- List drivers requests.");
                                System.out.println("2- Suspend a user.");
                                System.out.println("3- Add area to the discount areas. ");
                                System.out.println("4- Back to main menu");
                                adminChoice = input.nextInt();
                                switch (adminChoice) {
                                    case 1:
                                        adminControl.listDriversRequests();
                                        break;

                                    case 2:
                                        adminControl.suspendUser();
                                        break;
                                    case 3:
                                        adminControl.addDiscountArea();
                                        break;
                                    case 4:
                                        continue mainMenu;

                                    default:
                                        System.out.println("Wrong choice, Choose again");
                                        break;
                                }
                            }
                        } else {
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
            } catch (NullPointerException | ParseException | InterruptedException e) {
                e.printStackTrace();
            }catch (InputMismatchException e){
                e.printStackTrace();
            }
        }
    }
}