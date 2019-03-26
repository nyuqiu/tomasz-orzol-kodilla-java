package com.kodilla.rps;

import java.util.Scanner;

public class ChosenOptions {
    private Scanner scanner = new Scanner(System.in);
    private boolean end = false;

    public boolean finishingGame(){
        System.out.println("Do you really wanna finish game? y/n");
        String chooseOption = scanner.next();
        if (chooseOption.equals("y") || chooseOption.equals("n")) {
            switch (chooseOption) {
                case "y":
                    end = true;
                    System.out.println("Bye bye");
                    break;
                case "n":
                    System.out.println("Thanks for staying");
                    break;
            }
        }
        return end;
    }
    public boolean startAgain(){
        boolean result = false;
        System.out.println("Do you really wanna finish actual game? y/n");
        String chooseOption = scanner.next();
        if (chooseOption.equals("y") || chooseOption.equals("n")) {
            switch (chooseOption) {
                case "y":
                    result = true;
                    break;
                case "n":
                    result = false;
                    System.out.println("Playing the same game");
                    break;
            }
        }
        return result;
    }
}
