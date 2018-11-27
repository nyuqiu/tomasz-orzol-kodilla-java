package com.kodilla.exception.test;

import java.io.IOException;

public class SecondChallenge {
    public String probablyIWillThrowException(double x, double y) throws ExceptionHandling {
        try {
            if (x >= 2 || x < 1 || y == 1.5) {
                throw new IOException();
            }
        } catch(IOException e){
            throw new ExceptionHandling();
        } finally {
            System.out.println("Always exceptions!");
        }
        return "Done!";
    }
}