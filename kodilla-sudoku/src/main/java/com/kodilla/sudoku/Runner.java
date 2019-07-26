package com.kodilla.sudoku;

public class Runner {


    public static void main(String[] args) {
        BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();

        boolean gameFinished = false;
//        while (!gameFinished) {
        System.out.println("start test");
        SudokuGame theGame = new SudokuGame();
        SudokuBoard sudokuBoard = new SudokuBoard();
        System.out.println(sudokuBoard);

        int value = 9;
        for (int row = 0; row < 9; row++) {
            value += 4;
            for (int column = 0; column < 9; column++) {
                value++;
                sudokuBoard.setValue(column, row, String.valueOf(value % 9 + 1));
            }
        }
        backtrackCopies.getBacktrack().add(sudokuBoard);



        System.out.println(sudokuBoard);

        sudokuBoard.setValue(0, 0, "x");
        sudokuBoard.setValue(1, 1, "x");

        System.out.println(sudokuBoard);

        System.out.println("getting right part of code");
        gameFinished = theGame.resolveSudoku(sudokuBoard);

        System.out.println(sudokuBoard);

        System.out.println("finish test");


    }
}
