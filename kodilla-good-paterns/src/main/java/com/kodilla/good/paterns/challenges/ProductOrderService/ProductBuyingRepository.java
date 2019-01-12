package com.kodilla.good.paterns.challenges.ProductOrderService;

class ProductBuyingRepository implements BuyingRepository {

    @Override
    public boolean createOrder(User user, String product, String address) {
        System.out.println("Order for "+ user.getName()+user.getSurname()+" has been saved");
        return true;
    }
}
