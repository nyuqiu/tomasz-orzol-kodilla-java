package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = scanner.next();
        System.out.println("Hello " + name);
    }
}
