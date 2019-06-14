package com.kodilla.sudoku;

public class Runner {

    public static void main(String[] args) {

        boolean gameFinished = false;
        while (!gameFinished) {
            System.out.println("start test");
            SudokuGame theGame = new SudokuGame();
            SudokuBoard sudokuBoard = new SudokuBoard();
            sudokuBoard.setValue(1,1,1);
            sudokuBoard.setValue(1,2,2);
            sudokuBoard.setValue(1,3,3);
            sudokuBoard.setValue(1,4,4);
            sudokuBoard.setValue(1,5,5);
            sudokuBoard.setValue(1,6,6);
            sudokuBoard.setValue(1,7,7);
            sudokuBoard.setValue(1,8,8);
            sudokuBoard.setValue(1,0,9);

            gameFinished = theGame.resolveSudoku(sudokuBoard);
            System.out.println(sudokuBoard.toString());

            System.out.println("finish test");

        }
    }
}
