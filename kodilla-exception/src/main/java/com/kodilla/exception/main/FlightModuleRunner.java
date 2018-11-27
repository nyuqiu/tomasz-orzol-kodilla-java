package com.kodilla.exception.main;

import com.kodilla.exception.test.FindFlight;
import com.kodilla.exception.test.Flight;
import com.kodilla.exception.test.RouteNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlightModuleRunner {
    public static void main(String args[]) {
        FindFlight findFlight = new FindFlight();
        List<Flight> flights = new ArrayList<>();
        Flight flight1 = new Flight("Amsterdam", "Miami");
        Flight flight2 = new Flight("Warsaw", "Amsterdam");
        Flight flight3 = new Flight("Frankfurt", "Dubai");
        Flight flight4 = new Flight("London", "Pyoang");
        Flight flight5 = new Flight("New York", "London");
        Flight flight6 = new Flight("Moscow", "Vienna");
        Flight flight7 = new Flight("Bristol", "Rzeszow");
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        flights.add(flight5);
        flights.add(flight6);
        flights.add(flight7);


        for (Flight flight : flights) {
            try {
                Map<String, Boolean> canFlyTo = findFlight.findFlight(flight);
                System.out.println("Flight from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport() +
                        " can land in " + canFlyTo);
            } catch (RouteNotFoundException e) {
                System.out.println(e);
            }
        }
    }
}
