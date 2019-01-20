package com.kodilla.good.patterns.challenges.Flights;

//import java.util.List;
//import java.util.Objects;
//
//public class Flight{
//    private List<String> connections;
//
//    public Flight(List<String> connections) {
//        if(connections.size()==2) {
//            this.connections = connections;
//        }
//    }
//
//    public List<String> getConnections() {
//        return connections;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Flight flight = (Flight) o;
//        return Objects.equals(connections, flight.connections);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(connections);
//    }
//}

import java.util.Objects;

public class Flight {
    private String departureAirport;
    private String arrivalAirport;

    public Flight(String departureAirport, String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departureAirport, flight.departureAirport) &&
                Objects.equals(arrivalAirport, flight.arrivalAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureAirport, arrivalAirport);
    }
}
