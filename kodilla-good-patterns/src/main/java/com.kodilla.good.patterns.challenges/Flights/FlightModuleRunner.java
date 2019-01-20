package com.kodilla.good.patterns.challenges.Flights;

import java.util.*;

public class FlightModuleRunner {
    public static void main(String args[]) {

        FindFlight findFlight = new FindFlight();
        List<Flight> flights = new ArrayList<>();

        Flight AmsterdamMiami = new Flight("Amsterdam", "Miami");
        Flight AmsterdanDubai = new Flight("Amsterdam", "Dubai");
        Flight WarsawAmsterdam = new Flight("Warsaw", "Amsterdam");
        Flight WarsawLondon = new Flight("Warsaw", "London");
        Flight FrankfurtMiami = new Flight("Frankfurt", "Miami");
        Flight FrankfurtDubai = new Flight("Frankfurt", "Dubai");
        Flight LondonPyoang = new Flight("London", "Pyoang");
        Flight LondonRzeszow = new Flight("London", "Rzeszow");
        Flight NewYorkLondon = new Flight("New York", "London");
        Flight NewYorkVienna = new Flight("New York", "Vienna");
        Flight MoscowVienna = new Flight("Moscow", "Vienna");
        Flight MoscowNewYork = new Flight("Moscow", "New York");
        Flight BristolRzeszow = new Flight("Bristol", "Rzeszow");
        Flight BristolRadom = new Flight("Bristol", "Radom");
        flights.add(AmsterdamMiami);
        flights.add(AmsterdanDubai);
        flights.add(WarsawAmsterdam);
        flights.add(WarsawLondon);
        flights.add(FrankfurtMiami);
        flights.add(FrankfurtDubai);
        flights.add(LondonPyoang);
        flights.add(LondonRzeszow);
        flights.add(NewYorkLondon);
        flights.add(NewYorkVienna);
        flights.add(MoscowVienna);
        flights.add(MoscowNewYork);
        flights.add(BristolRadom);
        flights.add(BristolRzeszow);

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




