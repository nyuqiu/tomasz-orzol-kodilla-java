package com.kodilla.good.patterns.challenges.ProductOrderService;

class BuyRequestRetriever{

    public BuyingRequest retrieve(){

        User user = new User("John", "Wekl");

        String product = "Yellow Duck";

        String address = "Bristol";

        return new BuyingRequest(user, product, address);

    }
}
