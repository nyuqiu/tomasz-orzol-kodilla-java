package com.kodilla.good.patterns.challenges.food2Door;

import java.util.Map;

public class OrderDto {
    private final Map<String, Integer> readyToSent;
    private final Map<String, Integer> remainingProducts;

    public OrderDto(Map<String, Integer> readyToSent, Map<String, Integer> remainingProducts) {
        this.readyToSent = readyToSent;
        this.remainingProducts = remainingProducts;
    }

    public Map<String, Integer> getReadyToSent() {
        return readyToSent;
    }

    public Map<String, Integer> getRemainingProducts() {
        return remainingProducts;
    }
}
