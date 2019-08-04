package com.kodilla.sudoku;

public class Runner {


    public static void main(String[] args) {
        BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();

        boolean gameFinished = false;
        System.out.println("start test");
        SudokuBoard sudokuBoard = SudokuBoard.getInstance();

        System.out.println(sudokuBoard);
        System.out.println("pierwszy krok");
        SudokuGame theGame = new SudokuGame();

        backtrackCopies.getBacktrack().add(sudokuBoard);

        System.out.println(sudokuBoard);

        sudokuBoard.setValue(0, 0, "1");
        sudokuBoard.setValue(1, 1, "2");

        System.out.println("oryginal " + sudokuBoard);

        System.out.println("getting right part of code");

        gameFinished = theGame.resolveSudoku(sudokuBoard);


        System.out.println("oryginal " + sudokuBoard);



        System.out.println("finish test");


    }
}
