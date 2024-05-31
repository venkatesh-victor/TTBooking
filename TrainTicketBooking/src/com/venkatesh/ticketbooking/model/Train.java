package com.venkatesh.ticketbooking.model;

import java.util.List;
public class Train {
    private int trainNumber;
    private String trainName;
    private String depTime;
    private String arrTime;
    private int totalSeats;
    private List<String> stops;
    private int fare;

    public Train(int trainNumber, String trainName, String depTime, String arrTime,
                 int totalSeats, List<String> stops, int fare) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.totalSeats = totalSeats;
        this.stops = stops;
        this.fare = fare;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public List<String> getStops() {
        return stops;
    }

    public void setRouts(List<String> routs) {
        this.stops = stops;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNumber=" + trainNumber +
                ", trainName='" + trainName + '\'' +
                ", depTime='" + depTime + '\'' +
                ", arrTime='" + arrTime + '\'' +
                ", totalSeats=" + totalSeats +
                ", stops=" + stops +
                ", fare=" + fare +
                '}';
    }
}
