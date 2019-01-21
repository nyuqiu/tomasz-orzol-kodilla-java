package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculationsAdd(){
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double val = calculator.add(2.0,4.0);
        //Then
        Assert.assertEquals("Score is 6", 6.0, val, 0);
    }

    @Test
    public void testCalculationsSub(){
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double val = calculator.sub(2.0,4.0);
        //Then
        Assert.assertEquals("Score is -2", -2.0, val, 0);
    }

    @Test
    public void testCalculationsMul(){
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double val = calculator.mul(2.0,4.0);
        //Then
        Assert.assertEquals("Score is 8", 8.0, val, 0);
    }

    @Test
    public void testCalculationsDiv(){
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        //When
        double val = calculator.div(2.0,4.0);
        //Then
        Assert.assertEquals("Score is 0.5", 0.5, val, 0);
    }
}
