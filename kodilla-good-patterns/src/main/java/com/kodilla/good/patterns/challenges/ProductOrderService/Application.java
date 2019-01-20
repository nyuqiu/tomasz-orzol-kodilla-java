package com.kodilla.good.patterns.challenges.ProductOrderService;

class Application {
    public static void main(String[] args){
        BuyRequestRetriever buyRequestRetriever = new BuyRequestRetriever();
        BuyingRequest buyingRequest = buyRequestRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService(new EmailService());
        productOrderService.process(buyingRequest);
    }
}
