package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class ThinBaseDecorator extends AbstractPizzaOrderDecorator {
    public ThinBaseDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(0));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", thin base";
    }
}
