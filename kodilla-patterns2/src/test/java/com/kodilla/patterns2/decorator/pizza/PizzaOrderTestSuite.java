package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato base and cheese", description);
    }

    @Test
    public void testPizzaWithThinBaseGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ThinBaseDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15), theCost);
    }

    @Test
    public void testPizzaWithThinBaseGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ThinBaseDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato base and cheese, thin base", description);
    }

    @Test
    public void testPizzaWithOlivesAndFetaAndSpicyChickenGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new OlivesDercorator(theOrder);
        theOrder = new FetaDecorator(theOrder);
        theOrder = new SpicyChickenDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(31), theCost);
    }

    @Test
    public void testPizzaWithOlivesAndFetaAndSpicyChickenGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new OlivesDercorator(theOrder);
        theOrder = new FetaDecorator(theOrder);
        theOrder = new SpicyChickenDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato base and cheese, olives, feta, spicy chicken", description);
    }

    @Test
    public void testPizzaWithCheeseCrustGetCost(){
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new CheeseCrustDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(18.50), theCost);
    }

    @Test
    public void testPizzaWithCheeseCrustGetDescription(){
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new CheeseCrustDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza with tomato base and cheese, cheese crust", description);
    }
}