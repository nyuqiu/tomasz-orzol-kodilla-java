package com.kodilla.sudoku;

public class Runner {

    public static void main(String[] args) {
        BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
        SudokuBoard sudokuBoard = SudokuBoard.getInstance();
        backtrackCopies.getBacktrack().add(sudokuBoard);

        SudokuGame theGame = new SudokuGame();

        sudokuBoard.fillTheSudokuBoard(sudokuBoard, 0, 9);
        System.out.println(sudokuBoard);

        System.out.println("Amount of solved sudokus: " + theGame.resolveSudoku());
        System.out.println(theGame.finishedBoards);
    }
}