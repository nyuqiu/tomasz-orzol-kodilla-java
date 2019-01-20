package com.kodilla.good.patterns.challenges.food2Door;

import java.util.HashMap;
import java.util.Map;

public class OrderRequestRetriever {

    public OrderRequest retreive(){

        User user = new User("John", "Wekl");

        Map<String, Integer> orderedProducts = new HashMap<>();
        orderedProducts.put("sugar", 1000);
        orderedProducts.put("flour", 1000);
        orderedProducts.put("salt", 100);

        String address = "Bristol";

        return new OrderRequest(user, orderedProducts, address);

    }

}
