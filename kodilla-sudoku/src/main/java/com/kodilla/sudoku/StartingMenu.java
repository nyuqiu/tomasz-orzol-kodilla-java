package com.kodilla.sudoku;

import java.util.*;

public class StartingMenu {
    Scanner sc = new Scanner(System.in);
    Board board = Board.getInstance();

    public String startGame() {
        System.out.println("What is your name?");
        String player = sc.nextLine();
        System.out.println("Hello " + player + ". Press 1 for solving your board or 2 for partly filled board");

        switch (sc.nextInt()) {
            case 1:
                printMessageToEnterValue();
                while (sc.hasNext()) {
                    printMessageToEnterValue();
                    String input = sc.next();
                    if (Objects.equals(input, "end")) {
                        break;
                    }
                    List<String> userInput = Arrays.asList(input.split(","));
                    if (!(userInput.size() == 3)) {
                        System.out.println("Input incomplete. Try again.");
                    } else {
                        board.setValue(Integer.parseInt(userInput.get(0)), Integer.parseInt(userInput.get(1)), userInput.get(2));
                    }
                }
                break;
            case 2:
                System.out.println("How many columns you want have filled?");
                int columns = checkingRangeForFillingBoard();
                System.out.println("How many rows you want have filled?");
                int rows = checkingRangeForFillingBoard();
                board.fillTheSudokuBoardForTesting(board, columns, rows);
                break;
            default:
                System.out.println("Option doesn't exist, try again.");
                break;
        }
        System.out.println("Your board: \n" + board);
        return player;
    }

    private void printMessageToEnterValue() {
        System.out.println("Enter column and row number, and value for field, use coma as separator.\n" +
                "Type end to accept board.");
    }

    private int checkingRangeForFillingBoard () {
        int input = sc.nextInt();
        while (9 < input || input <= 0) {
            System.out.println("Wrong value, try again.");
            input = sc.nextInt();
        }
        return input;
    }
}
