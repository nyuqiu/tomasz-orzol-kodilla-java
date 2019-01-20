package com.kodilla.good.patterns.challenges.Flights;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindFlight {

    public Set<String> findFlightDirect(String airport, List<Flight> allConnections) {

        Set<String> destination = allConnections.stream()
                .filter(entry -> (entry.getArrivalAirport()).equals(airport) || (entry.getDepartureAirport()).equals(airport))
                .flatMap(entry -> Stream.of(entry.getArrivalAirport(), entry.getDepartureAirport()))
                .collect(Collectors.toSet());

        destination.remove(airport);

        return destination;
    }

    public Set<String> findFlightWithOneChange(String fromAirport, String toAirport, List<Flight> allConnections) {

        List<Flight> canFlyTo = allConnections.stream()
                .filter(entry -> ((entry.getArrivalAirport()).equals(fromAirport) || (entry.getDepartureAirport()).equals(fromAirport))
                        || (entry.getArrivalAirport()).equals(toAirport) || (entry.getDepartureAirport()).equals(toAirport))
                .collect(Collectors.toList());

        Set<String> possibleChanges = allConnections.stream()
                .filter(entry -> ((entry.getArrivalAirport()).equals(fromAirport) || (entry.getDepartureAirport()).equals(fromAirport))
                        || (entry.getArrivalAirport()).equals(toAirport) || (entry.getDepartureAirport()).equals(toAirport))
                .flatMap(entry -> Stream.of(entry.getArrivalAirport(), entry.getDepartureAirport()))
                .filter(entry -> !entry.equals(fromAirport))
                .filter(entry -> !entry.equals(toAirport))
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
            for (List<String> comparingFlight : airportsInArrays) {
                if (!flight.equals(comparingFlight)) {
                    for (String changes : possibleChanges) {
                        if (flight.contains(fromAirport) && comparingFlight.contains(toAirport) && flight.contains(changes) && comparingFlight.contains(changes)) {
                            confirmedChanges.add(changes);
                        }
                    }
                }
            }
        }
        return confirmedChanges;
    }
}
