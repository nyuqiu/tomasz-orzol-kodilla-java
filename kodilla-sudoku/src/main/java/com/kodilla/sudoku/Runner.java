package com.kodilla.sudoku;

public class Runner {

    public static void main(String[] args) {
        BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
        Board board = Board.getInstance();
        backtrackCopies.getBacktrack().add(board);

        SudokuGame theGame = new SudokuGame();

        board.fillTheSudokuBoard(board, 7, 9);
        System.out.println(board);

        System.out.println("Amount of solved sudokus: " + theGame.resolveSudoku());
        System.out.println(theGame.finishedBoards);
    }
}