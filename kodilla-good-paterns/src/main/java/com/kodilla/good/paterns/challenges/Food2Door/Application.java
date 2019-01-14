package com.kodilla.good.paterns.challenges.Food2Door;

public class Application {
    public static void main(String args[]) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retreive();

        orderRequest.createOrder();

    }
}
