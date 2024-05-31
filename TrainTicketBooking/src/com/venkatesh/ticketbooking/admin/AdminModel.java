package com.venkatesh.ticketbooking.admin;

import com.venkatesh.ticketbooking.datalayer.DataLayer;
import com.venkatesh.ticketbooking.model.Train;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AdminModel {
    private AdminView adminView;
    AdminModel(AdminView adminView) {
        this.adminView = adminView;
    }

    public void addTrain(int trainNum, String trainName, String depTime, String arrTime,
                         int noOfSeats, List<String> stops, int fare)
    {
        Train train = new Train(trainNum, trainName, depTime, arrTime, noOfSeats, stops, fare);
        DataLayer.getInstance().addTrain(train);

        JSONParser parser = new JSONParser();
        JSONArray jsonArray;

        try (FileReader reader = new FileReader("C:\\zoho\\TrainTicketBooking\\src\\com\\venkatesh\\ticketbooking\\datalayer\\trains.json")) {
            Object obj = parser.parse(reader);
            jsonArray = (JSONArray) obj;
        } catch (IOException | ParseException e) {
            jsonArray = new JSONArray();
        }

        JSONObject trainJson = new JSONObject();
        trainJson.put("trainNumber", train.getTrainNumber());
        trainJson.put("trainName", train.getTrainName());
        trainJson.put("depTime", train.getDepTime());
        trainJson.put("arrTime", train.getArrTime());
        trainJson.put("totalSeats", train.getTotalSeats());
        trainJson.put("stops", train.getStops());
        trainJson.put("fare", train.getFare());

        jsonArray.add(trainJson);

        try (FileWriter file = new FileWriter("C:\\zoho\\TrainTicketBooking\\src\\com\\venkatesh\\ticketbooking\\datalayer\\trains.json")) {
            file.write(jsonArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}