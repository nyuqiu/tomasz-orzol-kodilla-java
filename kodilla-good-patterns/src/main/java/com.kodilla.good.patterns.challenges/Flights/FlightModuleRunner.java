package com.kodilla.good.patterns.challenges.Flights;

import java.util.*;

public class FlightModuleRunner {
    public static void main(String args[]) {

        FindFlight findFlight = new FindFlight();
        List<Flight> flights = new ArrayList<>();

        Flight amsterdamMiami = new Flight("Amsterdam", "Miami");
        Flight amsterdanDubai = new Flight("Amsterdam", "Dubai");
        Flight warsawAmsterdam = new Flight("Warsaw", "Amsterdam");
        Flight warsawLondon = new Flight("Warsaw", "London");
        Flight frankfurtMiami = new Flight("Frankfurt", "Miami");
        Flight frankfurtDubai = new Flight("Frankfurt", "Dubai");
        Flight londonPyoang = new Flight("London", "Pyoang");
        Flight londonRzeszow = new Flight("London", "Rzeszow");
        Flight newYorkLondon = new Flight("New York", "London");
        Flight newYorkVienna = new Flight("New York", "Vienna");
        Flight moscowVienna = new Flight("Moscow", "Vienna");
        Flight moscowNewYork = new Flight("Moscow", "New York");
        Flight bristolRzeszow = new Flight("Bristol", "Rzeszow");
        Flight bristolRadom = new Flight("Bristol", "Radom");
        flights.add(amsterdamMiami);
        flights.add(amsterdanDubai);
        flights.add(warsawAmsterdam);
        flights.add(warsawLondon);
        flights.add(frankfurtMiami);
        flights.add(frankfurtDubai);
        flights.add(londonPyoang);
        flights.add(londonRzeszow);
        flights.add(newYorkLondon);
        flights.add(newYorkVienna);
        flights.add(moscowVienna);
        flights.add(moscowNewYork);
        flights.add(bristolRadom);
        flights.add(bristolRzeszow);

        String airportToOrFrom = "Warsaw";
        String airportWithOneChange = "Miami";

        Set<String> possibleConnectionsWithOneChange = findFlight.findFlightWithOneChange(airportToOrFrom, airportWithOneChange, flights);
        Set<String> possibleConncetions = findFlight.findFlightDirect(airportToOrFrom, flights);

        if(!(airportToOrFrom=="") && !(airportWithOneChange=="")){
            if (!(possibleConnectionsWithOneChange.size() == 0)) {
                System.out.println("You have possible connections available from " + airportToOrFrom + " to " + airportWithOneChange + " by " + possibleConnectionsWithOneChange);
            } else if(!(possibleConncetions==null)) {
                System.out.println("You have possible connection available from " + airportToOrFrom + " to " + airportWithOneChange);
            } else {
                System.out.println("Not avaliable connections from " + airportToOrFrom + " to " + airportWithOneChange);
            }
        } else if(!(airportToOrFrom=="")){
            if(possibleConncetions!=null) {
                System.out.println("You have possible connections available from/to " + airportToOrFrom + ": " + possibleConncetions);
            } else {
                System.out.println("Not avaliable connections from/to "+airportToOrFrom);
            }
        }
    }
}




