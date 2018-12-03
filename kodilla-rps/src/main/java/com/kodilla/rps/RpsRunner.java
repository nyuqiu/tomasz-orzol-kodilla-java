package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {
    public static void printOptions(){
        System.out.println("Menu:\n" +
                "1: Play stone.\n" +
                "2: Play paper.\n" +
                "3: Play scissors.\n" +
                "x: Finish game.\n" +
                "n: Start new game.\n" +
                "m: Print menu.");
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = scanner.next();
        System.out.println("Hello " + name);
        System.out.println("How many won rounds to win a game?");
        int wonRounds = scanner.nextInt();

        boolean end = false;
        printOptions();
        while(!end){
            switch (scanner.next()){
                case "1":
                    System.out.println("gra kamien");
                    break;

                case "2":
                    System.out.println("gra papier");
                    break;

                case "3":
                    System.out.println("gra nozyce");
                    break;

                case "x":
                    System.out.println("Do you really wanna finish game? y/n");
                    switch (scanner.next()){
                        case "y":
                            end = true;
                            System.out.println("Bye bye");
                            break;
                        case "n":
                            System.out.println("Thanks for staying");
                            break;
                    }
                    break;

                case "n":
                    System.out.println("Do you really wanna finish actual game? y/n");
                    switch (scanner.next()){
                        case "y":
                            System.out.println("Starting new game");
                            break;
                        case "n":
                            System.out.println("Playing the same game");
                            break;
                    }
                    break;

                case "m":
                    printOptions();
                    break;
            }
        }
    }
}
