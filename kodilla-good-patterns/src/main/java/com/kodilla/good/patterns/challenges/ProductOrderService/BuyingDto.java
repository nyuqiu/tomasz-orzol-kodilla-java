package com.kodilla.good.patterns.challenges.ProductOrderService;

class BuyingDto {

    private User user;
    private boolean bought;

    public BuyingDto(final User user, final boolean bought) {
        this.user = user;
        this.bought = bought;
    }

    public User getUser() {
        return user;
    }

    public boolean isBought() {
        return bought;
    }
}
