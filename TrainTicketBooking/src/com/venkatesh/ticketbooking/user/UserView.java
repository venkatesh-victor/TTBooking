package com.venkatesh.ticketbooking.user;

import com.venkatesh.ticketbooking.datalayer.DataLayer;
import com.venkatesh.ticketbooking.model.Booking;
import com.venkatesh.ticketbooking.model.Passenger;
import com.venkatesh.ticketbooking.model.Train;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class UserView {
    Scanner sc = new Scanner(System.in);
    private UserModel userModel;
    public UserView() {
        this.userModel = new UserModel(this);
    }

    public void init() {
        while (true) {
            System.out.println("1. See all the trains.");
            System.out.println("2. Search Trains.");
            System.out.println("3. Book a train ticket using train number.");
            System.out.println("4. Get tick status.");
            System.out.println("5. Cancel ticket");
            System.out.println("6. Exit application.");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    printTrains();
                    break;
                case 2:
                    searchTrains();
                    break;
                case 3:
                    bookTicket();
                    break;
                case 4:
                    //getStatus();
                    break;
                case 5:
                    //cancelTicket();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice try again.");
            }
        }
    }

    public void printTrains() {
        List<Train> trainList = userModel.retrieveTrainList();
        printList(trainList);
    }

    public void printList(List<Train> trainList) {
        for (Train train : trainList) {
            System.out.println("------------------------------------");
            System.out.println(train.toString());
            System.out.println("------------------------------------");
        }
    }

    public void searchTrains() {
        //
    }

    public void bookTicket() {
        System.out.print("Enter from station: ");
        String from = sc.nextLine();
        System.out.print("Enter to station: ");
        String to = sc.nextLine();

        List<Train> availableTrainList = userModel.searchTrains(from , to);

        if (availableTrainList.isEmpty()) {
            System.out.println("No trains available :(");
        } else {
            System.out.println("These are the available trains:-");
            printList(availableTrainList);
            System.out.print("Enter your name: ");
            String name = sc.nextLine();
            System.out.print("Enter your age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter your gender: ");
            String gender = sc.nextLine();
            System.out.print("Enter your id number: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter the train number from the available trains to book ticket");
            int trainNum = sc.nextInt();
            sc.nextLine();

            for (Train availableTrain : availableTrainList) {
                if (availableTrain.getTrainNumber() == trainNum) {
                    Passenger passenger = new Passenger(name, age, gender, id);
                    Booking newBooking = new Booking(passenger, availableTrain);
                    userModel.bookTicket(newBooking);
                    System.out.println("Ticket booked successfully");
                }
            }
        }
    }

}
