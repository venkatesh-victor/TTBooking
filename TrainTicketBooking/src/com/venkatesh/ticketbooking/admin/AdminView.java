package com.venkatesh.ticketbooking.admin;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminView {
    Scanner sc = new Scanner(System.in);
    private AdminModel adminModel;
    public AdminView() {
        this.adminModel = new AdminModel(this);
    }

    public void init() {
        while (true) {
            System.out.println("Do you want to add trains");
            char choice = sc.next().charAt(0);

            switch (choice) {
                case 'y':
                    addTrain();
                    break;
                case 'n':
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public void addTrain() {
        List<String> stops = new ArrayList<>();

        System.out.print("Enter train number: ");
        int trainNum = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Train Name: ");
        String trainName = sc.nextLine();
        System.out.print("Enter departure time: ");
        String depTime = sc.nextLine();
        System.out.print("Enter arrival time: ");
        String arrTime = sc.nextLine();
        System.out.print("Enter no of seats: ");
        int noOfSeats = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter fare: ");
        int fare = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter how many stops: ");
        int noOfStops = sc.nextInt();
        sc.nextLine();

        System.out.print("Etner stops one by one: ");
        for (int i = 0; i < noOfStops; i++) {
            System.out.print("Enter stop no "  + (i + 1));
            String stop = sc.nextLine();
            stops.add(stop);
        }

        adminModel.addTrain(trainNum, trainName, depTime, arrTime, noOfSeats, stops, fare);
    }
}
