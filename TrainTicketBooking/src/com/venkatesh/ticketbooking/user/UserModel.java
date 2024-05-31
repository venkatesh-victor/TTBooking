package com.venkatesh.ticketbooking.user;

import com.venkatesh.ticketbooking.datalayer.DataLayer;
import com.venkatesh.ticketbooking.model.Booking;
import com.venkatesh.ticketbooking.model.Passenger;
import com.venkatesh.ticketbooking.model.Train;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private UserView userView;
    UserModel(UserView userView) {
        this.userView = userView;
    }

    public List<Train> retrieveTrainList() {
        return DataLayer.getInstance().getTrainList();
    }

    public List<Train> getAllTrains() {
        List<Train> trainList = new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONArray jsonArray;

        try (FileReader reader = new FileReader("C:\\zoho\\TrainTicketBooking\\src\\com\\venkatesh\\ticketbooking\\datalayer\\trains.json")) {
            Object obj = parser.parse(reader);
            jsonArray = (JSONArray) obj;

            for (Object o : jsonArray) {
                JSONObject trainJson = (JSONObject) o;
                Train train = parseTrainFromJson(trainJson);
                trainList.add(train);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return trainList;
    }

    private Train parseTrainFromJson(JSONObject trainJson) {
        int trainNumber = ((Long) trainJson.get("trainNumber")).intValue();
        String trainName = (String) trainJson.get("trainName");
        String depTime = (String) trainJson.get("depTime");
        String arrTime = (String) trainJson.get("arrTime");
        int totalSeats = ((Long) trainJson.get("totalSeats")).intValue();
        List<String> stops = (List<String>) trainJson.get("stops");
        int fare = ((Long) trainJson.get("fare")).intValue();

        return new Train(trainNumber, trainName, depTime, arrTime, totalSeats, stops, fare);
    }

    public List<Train> searchTrains(String from, String to) {
        List<Train> filteredTrainList = new ArrayList<>();
        List<Train> allTrains = getAllTrains();

        for (Train train : allTrains) {
            List<String> stops = train.getStops();
            if (stops.contains(from) && stops.contains(to)) {
                filteredTrainList.add(train);
            }
        }

        return filteredTrainList;
    }

    public void bookTicket(Booking booking) {
        DataLayer.getInstance().addBooking(booking);
        JSONParser parser = new JSONParser();
        JSONArray bookingArray;

        try (FileReader reader = new FileReader("C:\\zoho\\TrainTicketBooking\\src\\com\\venkatesh\\ticketbooking\\datalayer\\bookings.json")) {
            Object obj = parser.parse(reader);
            bookingArray = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            bookingArray = new JSONArray();
        }

        JSONObject bookingObject = new JSONObject();
        bookingObject.put("passenger", passengerToJson(booking.getPassenger()));
        bookingObject.put("train", trainToJson(booking.getTrain()));

        bookingArray.add(bookingObject);

        try (FileWriter file = new FileWriter("C:\\zoho\\TrainTicketBooking\\src\\com\\venkatesh\\ticketbooking\\datalayer\\bookings.json")) {
            file.write(bookingArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private JSONObject passengerToJson(Passenger passenger) {
        JSONObject passengerObject = new JSONObject();
        passengerObject.put("name", passenger.getName());
        passengerObject.put("age", passenger.getAge());
        passengerObject.put("gender", passenger.getGender());
        passengerObject.put("id", passenger.getId());
        return passengerObject;
    }

    private JSONObject trainToJson(Train train) {
        JSONObject trainObject = new JSONObject();
        trainObject.put("trainNumber", train.getTrainNumber());
        trainObject.put("trainName", train.getTrainName());
        trainObject.put("depTime", train.getDepTime());
        trainObject.put("arrTime", train.getArrTime());
        trainObject.put("totalSeats", train.getTotalSeats());
        trainObject.put("stops", train.getStops());
        trainObject.put("fare", train.getFare());
        return trainObject;
    }
}
