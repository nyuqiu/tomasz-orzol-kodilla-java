package com.kodilla.good.patterns.challenges.food2Door;

import java.util.HashMap;
import java.util.Map;

public class GlutenFreeShop implements Producent {

    private ProductsAvaliablity productsAvaliablity = new ProductsAvaliablity();
    private Map<String, Integer> listOfProducts = new HashMap<>();

    @Override
    public Map<String, Integer> productsList (){
        if(listOfProducts!=null) {
            listOfProducts.put("bread", 10000);
            listOfProducts.put("buns", 200000);
            listOfProducts.put("beer", 1000);
        }
        return listOfProducts;
    }


    @Override
    public void process(OrderRequest orderRequest) {

        System.out.println("Checking products from GltuenFreeShop");

        OrderDto orderDto = productsAvaliablity.checkAvaliablity(orderRequest, productsList());

        Map<String, Integer> ordered =  orderDto.getReadyToSent();
        Map<String, Integer> available =  orderDto.getRemainingProducts();

        if(ordered.size()!=0){
            System.out.println("Products from GlutenFreeShop in basket, ready to sent: "+ordered);
            System.out.println("Products reamaining: "+available);
        } else {
            System.out.println("Not avaliable products.");
        }

    }
}
