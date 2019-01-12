package com.kodilla.good.paterns.challenges.Food2Door;

import java.util.HashMap;

public class Producent {

    private String name;
    private HashMap<String, Integer> products;

    public Producent(String name, HashMap<String, Integer> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Integer> getProducts() {
        return products;
    }
}
