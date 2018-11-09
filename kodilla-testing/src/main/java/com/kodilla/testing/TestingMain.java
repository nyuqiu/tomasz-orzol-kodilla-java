package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Test - pierwszy test jednostkowy:");

        Calculator calculator = new Calculator();

        int resultOfSubstracting = calculator.substract(10, 7);

        if(resultOfSubstracting==(10-7)){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        int resultOfAdding = calculator.addition(10, 7);

        if(resultOfAdding==(10+7)){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
    }
}