package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;


public class TestingMain {
    public static void main(String[] args){

        SimpleUser simpleUser = new SimpleUser("theForumUser", "Johnny Q");

        String result = simpleUser.getUsername();
        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        // tu umieść kolejny test ->
        System.out.println("Test - pierwszy test jednostkowy:");


        Calculator calculator = new Calculator();

        int addResult = calculator.addition(7, 3);
        int subResult = calculator.substract(7, 3);

        if((addResult == 10) && (subResult == 4)){
            System.out.println("Calculator test OK");
        } else {
            System.out.println("Calculator has error!");
        }

    }
}