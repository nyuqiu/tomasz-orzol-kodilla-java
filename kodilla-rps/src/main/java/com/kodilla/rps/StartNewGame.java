package com.kodilla.rps;

import java.util.Scanner;

public class StartNewGame {
    public NewGameDto startNewGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting new game");
        int playerOneWonRounds = 0;
        int playerTwoWonRounds = 0;
        int wonRounds = 0;
        int checkForInteger = 0;
        System.out.println("How many won rounds to win a game?");
        String input;
        while (wonRounds == 0) {
            try {
                input = scanner.next();
                checkForInteger = Integer.parseInt(input);
            } catch(NumberFormatException e) {
                System.out.println("Not integer, try again");
            }
            wonRounds = checkForInteger;
        }
        System.out.println("How much percent to win?");
        checkForInteger = -1;
        int percentWinningGames = -1;
        while (percentWinningGames == -1) {
            try {
                input = scanner.next();
                checkForInteger = Integer.parseInt(input);
            } catch(NumberFormatException e) {
                System.out.println("Not integer, or input is below 0 or above 100, try again");
            }
            percentWinningGames = checkForInteger;
        }
        return new NewGameDto(playerOneWonRounds, playerTwoWonRounds, wonRounds, percentWinningGames);
    }
}
