package com.kodilla.good.paterns.challenges.ProductOrderService;

interface BuyingRepository {

    boolean createOrder(User user, String product, String address);

}
