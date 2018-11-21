package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        // Given
        World world = new World();
        Country poland = new Country(new BigDecimal("10"));
        Country germany = new Country(new BigDecimal("5"));
        Country spain = new Country(new BigDecimal("15"));
        Country columbia = new Country(new BigDecimal("30"));
        Country mexico = new Country(new BigDecimal("15000000")); // without spaces in number
        Country canada = new Country(new BigDecimal("2"));
        Continent europe = new Continent();
        Continent america = new Continent();
        world.addContinent(europe);
        world.addContinent(america);
        europe.addCountry(poland);
        europe.addCountry(germany);
        europe.addCountry(spain);
        america.addCountry(columbia);
        america.addCountry(mexico);
        america.addCountry(canada);

        // When
        BigDecimal resultPeopleQuantity = world.getPeopleQuantity();

        // Then
        BigDecimal expectedPeopleQuantity = new BigDecimal("15000062");
        Assert.assertEquals(expectedPeopleQuantity, resultPeopleQuantity);
    }
}
