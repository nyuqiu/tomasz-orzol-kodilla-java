package com.kodilla.good.patterns.challenges.Food2Door;

import java.util.Map;

public class OrderDto {
    public final Map<String, Integer> readyToSent;
    public final Map<String, Integer> remainingProducts;

    public OrderDto(Map<String, Integer> readyToSent, Map<String, Integer> remainingProducts) {
        this.readyToSent = readyToSent;
        this.remainingProducts = remainingProducts;
    }
}
