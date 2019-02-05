package com.kodilla.rps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RpsRunner {
    public static void printOptions() {
        System.out.println("Menu:\n" +
                "1: Play stone.\n" +
                "2: Play paper.\n" +
                "3: Play scissors.\n" +
                "x: Finish game.\n" +
                "n: Start new game.\n" +
                "m: Print menu.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AvaliableMoves avaliableMoves = new AvaliableMoves();
        System.out.println("What is your name?");
        String name = scanner.next();
        System.out.println("Hello " + name);
        System.out.println("How many won rounds to win a game?");
        int wonRounds = scanner.nextInt();
        System.out.println("How much percent to win?");
        int percentWinningGames = scanner.nextInt();
        int playerOneWonRounds = 0;
        int playerTwoWonRounds = 0;
        Dao dao = null;
        List<String> keysToUse = new ArrayList<>();
        keysToUse.addAll(Arrays.asList("1","2","3","4","5","x","n","m"));

        boolean end = false;
        printOptions();
        while (!end) {
            String keyboardInput = scanner.next();
            if(keysToUse.contains(keyboardInput)) {
                switch (keyboardInput) {
                    case "1":
                        System.out.println("Play rock");
                        dao = avaliableMoves.play(Move.ROCK, percentWinningGames);
                        break;
                    case "2":
                        System.out.println("Play paper");
                        dao = avaliableMoves.play(Move.PAPER, percentWinningGames);
                        break;
                    case "3":
                        System.out.println("Play scissors");
                        dao = avaliableMoves.play(Move.SCISSORS, percentWinningGames);
                        break;
                    case "4":
                        System.out.println("Play Spock");
                        dao = avaliableMoves.play(Move.SPOCK, percentWinningGames);
                        break;
                    case "5":
                        System.out.println("Play lizard");
                        dao = avaliableMoves.play(Move.LIZARD, percentWinningGames);
                        break;
                    case "x":
                        System.out.println("Do you really wanna finish game? y/n");
                        String yesNoOption = scanner.next();
                        if(yesNoOption.equals("y") || yesNoOption.equals("n")) {
                        switch (yesNoOption) {
                                case "y":
                                    end = true;
                                    System.out.println("Bye bye");
                                    break;
                                case "n":
                                    System.out.println("Thanks for staying");
                                    break;
                            }
                        }
                        break;

                    case "n":
                        System.out.println("Do you really wanna finish actual game? y/n");
                        String yesNoOption1 = scanner.next();
                        if(yesNoOption1.equals("y") || yesNoOption1.equals("n")) {
                            switch (yesNoOption1) {
                                case "y":
                                    System.out.println("Starting new game");
                                    playerOneWonRounds = 0;
                                    playerTwoWonRounds = 0;
                                    System.out.println("How many won rounds to win a game?");
                                    wonRounds = scanner.nextInt();
                                    System.out.println("How much percent to win?");
                                    percentWinningGames = scanner.nextInt();
                                    printOptions();
                                    break;
                                case "n":
                                    System.out.println("Playing the same game");
                                    break;
                            }
                        }
                        break;

                    case "m":
                        printOptions();
                        break;
                }
            } else {
                System.out.println("Use one of those keys: "+keysToUse);
            }
            playerOneWonRounds += dao.getPlayerOneScore();
            playerTwoWonRounds += dao.getPlayerTwoScore();
            if (dao.getPlayerOneScore() == 1) {
                System.out.println(name + " scored one point!");
            } else if (dao.getPlayerTwoScore() == 1) {
                System.out.println("Computer scored one point!");
            }

            if (playerOneWonRounds == wonRounds || playerTwoWonRounds == wonRounds) {
                if (playerOneWonRounds > playerTwoWonRounds) {
                    System.out.println("Player " + name + " won game!!");
                    end = true;
                } else if (playerOneWonRounds < playerTwoWonRounds) {
                    System.out.println("Computer won game!");
                    end = true;
                }
            } else {
                printOptions();
            }
        }
    }
}