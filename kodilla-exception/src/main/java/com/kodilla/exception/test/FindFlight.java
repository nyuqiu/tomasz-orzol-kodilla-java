package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FindFlight {
    public Map<String, Boolean> findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> canFlyTo = new HashMap<>();
        canFlyTo.put("Amsterdam", false);
        canFlyTo.put("Frankfurt", false);
        canFlyTo.put("Warsaw", false);
        canFlyTo.put("New York", false);
        canFlyTo.put("London", false);
        canFlyTo.put("Dubai", false);

        Map<String, Boolean> resultsOfCanFlyTo = new HashMap<>();
        for (String key : canFlyTo.keySet()) {
            try {
                if (flight.getArrivalAirport() != null || flight.getDepartureAirport() != null) {
                    if (flight.getArrivalAirport() == key || flight.getDepartureAirport() == key) {
                        resultsOfCanFlyTo.put(key, true);
                    } else {
                        throw new RouteNotFoundException();
                    }
                } else {
                    throw new RouteNotFoundException();
                }
            } catch (RouteNotFoundException e) {
                System.out.println("Airport " + key + " not avaiable on map");
            }
        }
        return resultsOfCanFlyTo;
    }
}