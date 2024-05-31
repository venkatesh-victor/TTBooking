package com.venkatesh.ticketbooking.datalayer;

import com.venkatesh.ticketbooking.model.Booking;
import com.venkatesh.ticketbooking.model.Train;
import com.venkatesh.ticketbooking.model.Passenger;

import java.util.ArrayList;
import java.util.List;

public class DataLayer {
    private static DataLayer dataLayer;
    private List<Train> trainList = new ArrayList<>();
    private List<Booking> bookingsList = new ArrayList<>();

    public static DataLayer getInstance() {
        if (dataLayer == null) {
            dataLayer = new DataLayer();
        }
        return dataLayer;
    }

    public void addTrain(Train train) {
        trainList.add(train);
    }

    public void addBooking(Booking booking) {
        bookingsList.add(booking);
    }

    public List<Train> getTrainList() {
        return trainList;
    }
}
