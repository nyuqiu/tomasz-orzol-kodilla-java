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
