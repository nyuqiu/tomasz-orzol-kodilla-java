package com.kodilla.good.paterns.challenges.Food2Door;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtraFoodShop implements Producent{

    ProductsAvaliablity productsAvaliablity = new ProductsAvaliablity();
    Map<String, Integer> listOfProducts = new HashMap<>();

    @Override
    public Map<String, Integer> productsList (Map<String, Integer> avaiableProducts){
        if(avaiableProducts!=null) {
            listOfProducts.put("sugar", 10000);
            listOfProducts.put("flour", 200000);
            listOfProducts.put("salt", 1000);
        }
        return listOfProducts;
    }


    @Override
    public void process(OrderRequest orderRequest) {

        List<Map<String, Integer>> orderedAndAvaliableMaps =  productsAvaliablity.checkAvaliablity(orderRequest, productsList(listOfProducts));

        Map<String, Integer> ordered =  orderedAndAvaliableMaps.get(0);
        Map<String, Integer> available =  orderedAndAvaliableMaps.get(1);

        orderRequest.createOrder(orderRequest.getUser(), orderRequest.getOrderedProducts() , orderRequest.getAddress());


        if(ordered!=null){
            System.out.println("Products in basket, ready to sent: "+ordered);
            System.out.println("Products reamaining: "+available);
        }

    }
}
