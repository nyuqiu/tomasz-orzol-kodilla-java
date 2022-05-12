package com.kodilla.sudoku;

public class Runner {

    public static void main(String[] args) {
        SudokuGame theGame = new SudokuGame();
        StartingMenu startingMenu = new StartingMenu();
        String name = startingMenu.startGame();

        System.out.println("Amount of solved sudokus for " + name + ": " + theGame.resolveSudoku());
        System.out.println("Solved sudoku: \n" + theGame.finishedBoards.get(0));
    }
}