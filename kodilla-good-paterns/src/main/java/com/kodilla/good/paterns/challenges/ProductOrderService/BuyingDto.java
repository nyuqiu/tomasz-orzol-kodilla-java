package com.kodilla.good.paterns.challenges.ProductOrderService;

class BuyingDto {

    private User user;
    private boolean isBought;

    public BuyingDto(final User user, final boolean isBought) {
        this.user = user;
        this.isBought = isBought;
    }

    public User getUser() {
        return user;
    }

    public boolean isBought() {
        return isBought;
    }
}
