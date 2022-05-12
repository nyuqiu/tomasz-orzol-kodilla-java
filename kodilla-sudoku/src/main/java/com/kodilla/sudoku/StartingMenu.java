package com.kodilla.sudoku;

import java.util.Scanner;

public class StartingMenu {
    Scanner sc = new Scanner(System.in);
    Board board = Board.getInstance();

    public String startGame() {
        System.out.println("What is your name?");
        String player = sc.next();
        System.out.println("Hello " + player + ". Press 1 for solving your board or 2 for partly filled board");

        switch (sc.nextInt()) {
            case 1:
                for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
                    for (int rowNumber = 0; rowNumber < 9; rowNumber++) {
                        System.out.println("Enter value for column " + columnNumber + " and row " + rowNumber);
                        while (board.fieldByColumnAndRow(columnNumber, rowNumber).getValue().equals(Element.EMPTY)) {
                            board.setValue(columnNumber, rowNumber, sc.next());
                        }
                    }
                }
            case 2:
                // add statment
                System.out.println("How many columns you want have filled?");
                int columns = sc.nextInt();
                System.out.println("How many rows you want have filled?");
                int rows = sc.nextInt();
                board.fillTheSudokuBoardForTesting(board, columns - 1, rows - 1);
        }
        System.out.println("Your board: \n" + board);
        return player;
    }
}
