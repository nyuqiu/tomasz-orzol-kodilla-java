package com.kodilla.good.paterns.challenges.ProductOrderService;

class Application {
    public static void main(String[] args){
        BuyRequestRetriever buyRequestRetriever = new BuyRequestRetriever();
        BuyingRequest buyingRequest = buyRequestRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService(new EmailService(), new ProductBuyingService(), new ProductBuyingRepository());
        productOrderService.process(buyingRequest);
    }
}
