package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country{
    private BigDecimal peopleQuantity;

    public Country(BigDecimal peopleAmount) {
        this.peopleQuantity = peopleAmount;
    }

    public BigDecimal getPeopleQuantity() {
        return peopleQuantity;
    }
}
