package com.kodilla.good.paterns.challenges.Food2Door;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductsAvaliablity {

    public List<Map<String, Integer>> checkAvaliablity(OrderRequest orderRequest, Map<String, Integer> avaiableProducts){

        List<Map<String, Integer>> orderedAndAvaliable = new ArrayList<>();

        Map<String, Integer> orderedProducts = orderRequest.getOrderedProducts();

        for(Map.Entry<String, Integer> entry : avaiableProducts.entrySet()){
            String product = entry.getKey();
            Integer amount = entry.getValue();

            for(Map.Entry<String, Integer> entry1 : orderedProducts.entrySet()){
                String orderedPoduct = entry1.getKey();
                Integer amountOrdered = entry1.getValue();

                if(product==orderedPoduct){
                    int newAmount = amount-amountOrdered;
                    if(newAmount>0) {
                        avaiableProducts.put(product, newAmount);
                        System.out.println(product+" avaliable.");
                    } else {
                        avaiableProducts.put(product, amount);
                        System.out.println(product+" not enough avaiable." + " Ordered "+amountOrdered+" available "+amount);
                    }

                } else {
                    orderedProducts.remove(orderedPoduct);
                    System.out.println(product+" not avaliable");
                }

            }

        }

        orderedAndAvaliable.add(orderedProducts);
        orderedAndAvaliable.add(avaiableProducts);

        return orderedAndAvaliable;
    }
}
