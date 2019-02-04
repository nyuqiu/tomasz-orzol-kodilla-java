package com.kodilla.rps;

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

        boolean end = false;
        printOptions();
        while (!end) {
            switch (scanner.next()) {
                case "1":
                    System.out.println("Play stone");
                    dao = avaliableMoves.playStone(percentWinningGames);
                    break;
                case "2":
                    System.out.println("Play paper");
                    dao = avaliableMoves.playStone(percentWinningGames);
                    break;
                case "3":
                    System.out.println("Play scissors");
                    dao = avaliableMoves.playStone(percentWinningGames);
                    break;
                case "x":
                    System.out.println("Do you really wanna finish game? y/n");
                    switch (scanner.next()) {
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
                    switch (scanner.next()) {
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
                    break;

                case "m":
                    printOptions();
                    break;
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