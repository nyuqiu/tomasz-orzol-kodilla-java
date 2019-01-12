package com.kodilla.good.paterns.challenges.ProductOrderService;

class ProductBuyingService implements BuyingService{

    @Override
    public boolean buy(User user, String product, String address) {
        if(product!=null && address!=null) {
            System.out.println("Creating order for "+ user.getName()+user.getSurname()+" with product "+product+ ", for address "+address);
            return true;
        } else {
            System.out.println("Product not avaiable/Address not correct");
            return false;
        }
    }
}
