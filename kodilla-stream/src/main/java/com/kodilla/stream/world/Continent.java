package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    private List<Country> countries = new ArrayList<>();

    public Continent() {
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void addCountry(Country country){
        countries.add(country);
    }

}
