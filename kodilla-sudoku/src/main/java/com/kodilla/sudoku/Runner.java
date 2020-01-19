package com.kodilla.sudoku;

public class Runner {

    public static void main(String[] args) {
        BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();

        boolean gameFinished = false;
        System.out.println("start test");
        SudokuBoard sudokuBoard = SudokuBoard.getInstance();

        SudokuGame theGame = new SudokuGame();

        System.out.println(sudokuBoard);

        sudokuBoard.fillTheSudokuBoard(sudokuBoard,9,8);

        System.out.println("oryginal " + "\n" + sudokuBoard);

        System.out.println("getting right part of code");

        gameFinished = theGame.resolveSudoku(sudokuBoard);


        System.out.println("oryginal " + "\n" + sudokuBoard);


        System.out.println("finish test");


    }


}
