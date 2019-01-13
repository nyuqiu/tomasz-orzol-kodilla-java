package com.kodilla.good.paterns.challenges.ProductOrderService;

class BuyingRequest {

    private User user;
    private String product;
    private String address;

    public BuyingRequest(final User user, final String product, final String address) {
        this.user = user;
        this.product = product;
        this.address = address;
    }

    public boolean createOrder(User user, String product, String address) {
        if(product!=null && address!=null) {
            System.out.println("Creating order for "+ user.getName()+" "+user.getSurname()+" with product "+product+ ", for address "+address);
            return true;
        } else {
            System.out.println("Product not avaiable/Address not correct");
            return false;
        }
    }



    public User getUser() {
        return user;
    }

    public String getProduct() {
        return product;
    }

    public String getAddress() {
        return address;
    }
}
