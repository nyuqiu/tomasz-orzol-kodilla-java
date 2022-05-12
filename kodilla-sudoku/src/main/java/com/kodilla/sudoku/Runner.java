package com.kodilla.sudoku;

public class Runner {

    public static void main(String[] args) {
        Board board = Board.getInstance();
        SudokuGame theGame = new SudokuGame();

        board.fillTheSudokuBoardForTesting(board, 9, 7);
        System.out.println(board);

        System.out.println("Amount of solved sudokus: " + theGame.resolveSudoku());
        System.out.println("Solved sudoku: \n" +theGame.finishedBoards.get(0));
    }
}