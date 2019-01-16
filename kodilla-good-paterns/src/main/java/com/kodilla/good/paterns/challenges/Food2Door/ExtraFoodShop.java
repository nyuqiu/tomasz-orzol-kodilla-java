package com.kodilla.good.paterns.challenges.Food2Door;

import java.util.HashMap;
import java.util.Map;

public class ExtraFoodShop implements Producent{

    ProductsAvaliablity productsAvaliablity = new ProductsAvaliablity();
    Map<String, Integer> listOfProducts = new HashMap<>();

    @Override
    public Map<String, Integer> productsList (){
        if(listOfProducts!=null) {
            listOfProducts.put("sugar", 10000);
            listOfProducts.put("flour", 200000);
            listOfProducts.put("salt", 1000);
        }
        return listOfProducts;
    }


    @Override
    public void process(OrderRequest orderRequest) {

        OrderDto orderDto = productsAvaliablity.checkAvaliablity(orderRequest, productsList());

        Map<String, Integer> ordered =  orderDto.readyToSent;
        Map<String, Integer> available =  orderDto.remainingProducts;

        orderRequest.createOrder(orderRequest.getUser(), orderRequest.getOrderedProducts() , orderRequest.getAddress());


        if(ordered!=null){
            System.out.println("Products in basket, ready to sent: "+ordered);
            System.out.println("Products reamaining: "+available);
        } else {
            System.out.println("Order couldnt be completed, not avaliable products.");
        }

    }
}
