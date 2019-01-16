package com.kodilla.good.paterns.challenges.Food2Door;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductsAvaliablity {

    public OrderDto checkAvaliablity(OrderRequest orderRequest, Map<String, Integer> avaiableProducts) {

        List<Map<String, Integer>> orderedAndAvaliable = new ArrayList<>();
        Map<String, Integer> orderedProducts = orderRequest.getOrderedProducts();
        Map<String, Integer> productsToSent = new HashMap<>();

        for (Map.Entry<String, Integer> entry : orderedProducts.entrySet()) {
            String orderedProduct = entry.getKey();
            Integer orderedAmount = entry.getValue();

            boolean isAvaliable = avaiableProducts.containsKey(orderedProduct);
            int amountOrdered = orderedProducts.get(orderedProduct);

            if (isAvaliable) {
                int amountAvaiable = avaiableProducts.get(orderedProduct);
                int newAmount = amountAvaiable - amountOrdered;
                if (newAmount > 0) {
                    productsToSent.put(orderedProduct, amountOrdered);
                    avaiableProducts.put(orderedProduct, newAmount);
                    System.out.println(orderedProduct + " is avaliable.");
                } else {
                    avaiableProducts.put(orderedProduct, amountAvaiable);
                    System.out.println(orderedAmount + " not enough avaiable." + " Ordered " + amountOrdered + ", available " + amountAvaiable);
                }
            } else {
                productsToSent.put(orderedProduct, 0);
            }
        }

        OrderDto orderDto = new OrderDto(productsToSent, avaiableProducts);

        return orderDto;
    }
}



