package com.kodilla.exception.test;

import java.util.*;

public class FindFlight {
    public Map<String, Boolean> findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> canFlyTo = new HashMap<>();
        canFlyTo.put("Amsterdam", false);
        canFlyTo.put("Frankfurt", false);
        canFlyTo.put("Warsaw", false);
        canFlyTo.put("New York", false);
        canFlyTo.put("London", false);
        canFlyTo.put("Dubai", false);

        Set<String> airportsNotExsistTest = new HashSet<>();
        Set<String> airportsNotExsist = new HashSet<>();

        try {
            for (String key : canFlyTo.keySet()) {
                if (flight.getArrivalAirport() != null || flight.getDepartureAirport() != null) {
                    if (flight.getArrivalAirport() == key) {
                        canFlyTo.replace(key, true);
                    } else {
                        airportsNotExsistTest.add(flight.getArrivalAirport());
                        airportsNotExsist.add(flight.getArrivalAirport());
                    }
                    if (flight.getDepartureAirport() == key) {
                        canFlyTo.replace(key, true);
                    } else {
                        airportsNotExsistTest.add(flight.getDepartureAirport());
                        airportsNotExsist.add(flight.getDepartureAirport());
                    }
                } else {
                    System.out.println("Arrival and departure airport are unknown.");
                }
            }
            System.out.println("Flight from "+flight.getDepartureAirport()+" to "+flight.getArrivalAirport());

            for (String key1 : canFlyTo.keySet()) {
                for (String airport : airportsNotExsistTest) {
                    if (key1 == airport) {
                        airportsNotExsist.remove(airport);
                    }
                }
            }
            if (airportsNotExsist.size() > 0) {
                throw new RouteNotFoundException();
            }
        } catch (RouteNotFoundException e) {
            for (String airport : airportsNotExsist) {
                System.out.println("Airport " + airport + " not avaiable on map");
            }
        }
        Map<String, Boolean> resultOfCanFlyTo = canFlyTo;
        for (int i=0; i<canFlyTo.size()*10; i++) {
            resultOfCanFlyTo.values().remove(false);
            }

        return resultOfCanFlyTo;
    }

    //testtest

}


