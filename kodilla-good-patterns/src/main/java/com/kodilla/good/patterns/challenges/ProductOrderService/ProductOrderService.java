package com.kodilla.good.patterns.challenges.ProductOrderService;

public class ProductOrderService {

    private InformationService informationService;

    public ProductOrderService(final InformationService informationService) {
        this.informationService = informationService;

    }

    public BuyingDto process(final BuyingRequest buyingRequest) {
        boolean isBought = buyingRequest.createOrder(buyingRequest.getUser(), buyingRequest.getProduct(),
                buyingRequest.getAddress());

        if (isBought) {
            informationService.inform(buyingRequest.getUser());
            return new BuyingDto(buyingRequest.getUser(), true);
        } else {
            return new BuyingDto(buyingRequest.getUser(), false);
        }
    }

}

