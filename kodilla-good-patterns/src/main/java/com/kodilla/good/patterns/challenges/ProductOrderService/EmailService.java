package com.kodilla.good.patterns.challenges.ProductOrderService;

class EmailService implements InformationService {

    @Override
    public void inform(User user) {
        System.out.println("Order has been created for "+user.getName()+user.getSurname());
    }
}
