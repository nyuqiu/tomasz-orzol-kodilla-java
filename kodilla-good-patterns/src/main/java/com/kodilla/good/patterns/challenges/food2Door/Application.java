package com.kodilla.good.patterns.challenges.food2Door;

public class Application {
    public static void main(String args[]) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retreive();

        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        extraFoodShop.process(orderRequest);

    }
}
