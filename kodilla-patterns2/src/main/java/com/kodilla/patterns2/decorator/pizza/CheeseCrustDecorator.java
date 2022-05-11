package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class CheeseCrustDecorator extends AbstractPizzaOrderDecorator {
    public CheeseCrustDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(3.50));
    }

    @Override
    public String getDescription() {
        return super.getDescription()+ ", cheese crust";
    }
}
