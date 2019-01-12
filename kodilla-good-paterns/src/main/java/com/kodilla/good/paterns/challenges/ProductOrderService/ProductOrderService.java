package com.kodilla.good.paterns.challenges.ProductOrderService;

public class ProductOrderService {

    private InformationService informationService;
    private BuyingService buyingService;
    private BuyingRepository buyingRepository;

    public ProductOrderService(final InformationService informationService,
                               final BuyingService buyingService,
                               final BuyingRepository buyingRepository) {
        this.informationService = informationService;
        this.buyingService = buyingService;
        this.buyingRepository = buyingRepository;
    }

    public BuyingDto process(final BuyingRequest buyingRequest) {
        boolean isBought = buyingService.buy(buyingRequest.getUser(), buyingRequest.getProduct(),
                buyingRequest.getAddress());

        if (isBought) {
            informationService.inform(buyingRequest.getUser());
            buyingRepository.createOrder(buyingRequest.getUser(), buyingRequest.getProduct(), buyingRequest.getAddress());
            return new BuyingDto(buyingRequest.getUser(), true);
        } else {
            return new BuyingDto(buyingRequest.getUser(), false);
        }
    }

}

