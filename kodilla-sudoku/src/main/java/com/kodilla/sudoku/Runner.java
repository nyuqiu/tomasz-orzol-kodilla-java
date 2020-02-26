package com.kodilla.sudoku;

public class Runner {

    public static void main(String[] args) {
        BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
        SudokuBoard sudokuBoard = SudokuBoard.getInstance();
        backtrackCopies.getBacktrack().add(sudokuBoard);

        SudokuGame theGame = new SudokuGame();

        sudokuBoard.fillTheSudokuBoard(sudokuBoard,1,1);

        System.out.println("Amount of solved sudokus: " + theGame.resolveSudoku());


    }


}
