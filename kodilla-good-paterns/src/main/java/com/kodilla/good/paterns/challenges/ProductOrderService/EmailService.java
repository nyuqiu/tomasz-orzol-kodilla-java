package com.kodilla.good.paterns.challenges.ProductOrderService;

class EmailService implements InformationService {

    @Override
    public void inform(User user) {
        System.out.println("Order has been created for "+user.getName()+user.getSurname());
    }
}
