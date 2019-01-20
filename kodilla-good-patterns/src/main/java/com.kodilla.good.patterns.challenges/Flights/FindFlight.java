package com.kodilla.good.patterns.challenges.Flights;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindFlight {

    public Set<String> findFlightDirect(String airport, List<Flight> canFlyToOrigin) {

        List<Flight> canFlyTo = new ArrayList<>(canFlyToOrigin);
        Set<String> destination = canFlyTo.stream()
                .filter(entry -> (entry.getArrivalAirport()).equals(airport) || (entry.getDepartureAirport()).equals(airport))
                .flatMap(entry -> Stream.of(entry.getArrivalAirport(), entry.getDepartureAirport()))
                .collect(Collectors.toSet());

        destination.remove(airport);

        return destination;
    }

    public Set<String> findFlightWithOneChange(String airport, String airport2, List<Flight> canFlyToOrigin) {

        List<Flight> canFlyTo = canFlyToOrigin.stream()
                .filter(entry -> ((entry.getArrivalAirport()).equals(airport) || (entry.getDepartureAirport()).equals(airport))
                        || (entry.getArrivalAirport()).equals(airport2) || (entry.getDepartureAirport()).equals(airport2))
                .collect(Collectors.toList());

        Set<String> possibleChanges = canFlyToOrigin.stream()
                .filter(entry -> ((entry.getArrivalAirport()).equals(airport) || (entry.getDepartureAirport()).equals(airport))
                        || (entry.getArrivalAirport()).equals(airport2) || (entry.getDepartureAirport()).equals(airport2))
                .flatMap(entry -> Stream.of(entry.getArrivalAirport(), entry.getDepartureAirport()))
                .filter(entry -> !entry.equals(airport))
                .filter(entry -> !entry.equals(airport2))
                .collect(Collectors.toSet());

        List<List<String>> airportsInArrays = new ArrayList<>();
        for (Flight flight : canFlyTo) {
            List<String> airports = new ArrayList<>();
            airports.add(flight.getArrivalAirport());
            airports.add(flight.getDepartureAirport());
            airportsInArrays.add(airports);
        }
        Set<String> confirmedChanges = new HashSet<>();
        for (List<String> flight : airportsInArrays) {
            for (List<String> flight1 : airportsInArrays) {
                if (!flight.equals(flight1)) {
                    for (String changes : possibleChanges) {
                        if (flight.contains(airport) && flight1.contains(airport2) && flight.contains(changes) && flight1.contains(changes)) {
                            confirmedChanges.add(changes);
                        }
                    }
                }
            }
        }
        return confirmedChanges;
    }
}
