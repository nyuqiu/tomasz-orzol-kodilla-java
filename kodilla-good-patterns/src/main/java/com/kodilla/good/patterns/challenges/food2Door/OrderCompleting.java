package com.kodilla.good.patterns.challenges.food2Door;

public class OrderCompleting {

    OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
    OrderRequest orderRequest = orderRequestRetriever.retreive();

    ExtraFoodShop extraFoodShop = new ExtraFoodShop();
    HealthyShop healthyShop = new HealthyShop();
    GlutenFreeShop glutenFreeShop = new GlutenFreeShop();

    public void orderCompleting(){
        orderRequest.createOrder(orderRequest.getUser(), orderRequest.getOrderedProducts() , orderRequest.getAddress());

        extraFoodShop.process(orderRequest);
        healthyShop.process(orderRequest);
        glutenFreeShop.process(orderRequest);
    }
}
