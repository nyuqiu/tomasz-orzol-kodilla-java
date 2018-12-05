package com.kodilla.exception.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindFlight {

    public Set<String> airportsNotExist(Flight flight, Map<String, Boolean> canFlyToOrigin) throws RouteNotFoundException {

        Map<String, Boolean> canFlyTo = new HashMap<>(canFlyToOrigin);

        Set<String> airportsNotExsist = new HashSet<>();

        try {
            for (String key : canFlyTo.keySet()) {
                if (flight.getArrivalAirport() != null || flight.getDepartureAirport() != null) {
                    if (!flight.getArrivalAirport().equals(key)) {
                        airportsNotExsist.add(flight.getArrivalAirport());
                    }
                    if (!flight.getDepartureAirport().equals(key)) {
                        airportsNotExsist.add(flight.getDepartureAirport());
                    }
                } else {
                    System.out.println("Arrival and departure airport are unknown.");
                }
            }

            System.out.println("Flight from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport());

            airportsNotExsist = airportsNotExsist.stream()
                    .filter(n -> !canFlyTo.keySet().contains(n))
                    .collect(Collectors.toSet());

            if (airportsNotExsist.size() > 0) {
                throw new IOException();
            }
        } catch (IOException e) {
            throw new RouteNotFoundException();
        }
        return airportsNotExsist;
    }

    public Map<String, Boolean> findFlight(Flight flight, Map<String, Boolean> canFlyToOrigin) throws RouteNotFoundException {

        Map<String, Boolean> canFlyTo = new HashMap<>(canFlyToOrigin);
        Map<String, Boolean> canFlyToTrueValues = canFlyTo;
        canFlyTo.entrySet().stream()
                .filter(entry -> entry.getKey().equals(flight.getArrivalAirport()) || entry.getKey().equals(flight.getDepartureAirport()))
                .forEach(entry -> canFlyToTrueValues.replace(entry.getKey(), entry.getValue(), entry.setValue(true)));

        Map<String, Boolean> resultCanFlyTo = new HashMap<>();
        canFlyToTrueValues.entrySet().stream()
                .filter(entry -> entry.getValue())
                .forEach(entry -> resultCanFlyTo.put(entry.getKey(), entry.getValue()));
        return resultCanFlyTo;
    }
}
