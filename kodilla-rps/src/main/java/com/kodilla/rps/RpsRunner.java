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
                "4: Play Spock.\n" +
                "5: Play lizard.\n" +
                "x: Finish game.\n" +
                "n: Start new game.\n" +
                "m: Print menu.");
    }

    public static void main(String[] args) {
        StartNewGame startNewGame = new StartNewGame();
        ChosenOptions chosenOptions = new ChosenOptions();
        Scanner scanner = new Scanner(System.in);
        RoundResult roundResult = new RoundResult();
        System.out.println("What is your name?");
        String name = scanner.next();
        System.out.println("Hello " + name);
        NewGameDto newGame = startNewGame.startNewGame();
        int wonRounds = newGame.getHowManyRoundsToWin();
        int percentWinningGames = newGame.getHowManyPercentToWin();
        int playerOneWonRounds = newGame.getPlayerOneWonRounds();
        int playerTwoWonRounds = newGame.getPlayerTwoWonRounds();
        PlayersScoresDto playersScoresDto = null;
        List<String> keysToUse = new ArrayList<>();
        keysToUse.addAll(Arrays.asList("1", "2", "3", "4", "5", "x", "n", "m"));

        boolean end = false;
        boolean gameInterupted = false;
        while (!end) {
            printOptions();
            String keyboardInput = scanner.next();
            if (keysToUse.contains(keyboardInput)) {
                gameInterupted = false;
                switch (keyboardInput) {
                    case "1":
                        System.out.println("Play rock");
                        playersScoresDto = roundResult.play(Move.ROCK, percentWinningGames);
                        break;
                    case "2":
                        System.out.println("Play paper");
                        playersScoresDto = roundResult.play(Move.PAPER, percentWinningGames);
                        break;
                    case "3":
                        System.out.println("Play scissors");
                        playersScoresDto = roundResult.play(Move.SCISSORS, percentWinningGames);
                        break;
                    case "4":
                        System.out.println("Play Spock");
                        playersScoresDto = roundResult.play(Move.SPOCK, percentWinningGames);
                        break;
                    case "5":
                        System.out.println("Play lizard");
                        playersScoresDto = roundResult.play(Move.LIZARD, percentWinningGames);
                        break;
                    case "x":
                        end = chosenOptions.finishingGame();
                        gameInterupted = true;
                        break;
                    case "n":
                        gameInterupted = chosenOptions.startAgain();
                        if(gameInterupted){
                            NewGameDto nextGame = startNewGame.startNewGame();
                            wonRounds = nextGame.getHowManyRoundsToWin();
                            percentWinningGames = nextGame.getHowManyPercentToWin();
                            playerOneWonRounds = nextGame.getPlayerOneWonRounds();
                            playerTwoWonRounds = nextGame.getPlayerTwoWonRounds();
                        }
                        break;
                    case "m":
                        gameInterupted = true;
                        printOptions();
                        break;
                }
            } else {
                System.out.println("Use one of those keys: " + keysToUse);
                gameInterupted = true;
            }
            if(!gameInterupted) {
                playerOneWonRounds += playersScoresDto.getPlayerOneScore();
                playerTwoWonRounds += playersScoresDto.getPlayerTwoScore();
                if (playersScoresDto.getPlayerOneScore() == 1) {
                    System.out.println(name + " scored one point!");
                } else if (playersScoresDto.getPlayerTwoScore() == 1) {
                    System.out.println("Computer scored one point!");
                } else {
                    System.out.println("Draw!");
                }
            }
            System.out.println(name+" "+playerOneWonRounds+" : "+playerTwoWonRounds+" Computer");

            if (playerOneWonRounds == wonRounds || playerTwoWonRounds == wonRounds) {
                if (playerOneWonRounds > playerTwoWonRounds) {
                    System.out.println("Player " + name + " won game!!");
                    end = true;
                } else if (playerOneWonRounds < playerTwoWonRounds) {
                    System.out.println("Computer won game!");
                    end = true;
                }
            }
        }
    }
}