package com.venkatesh.ticketbooking.model;

public class Booking {
    Passenger passenger;
    Train train;

    public Booking(Passenger passenger, Train train) {
        this.passenger = passenger;
        this.train = train;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Train getTrain() {
        return train;
    }
}
