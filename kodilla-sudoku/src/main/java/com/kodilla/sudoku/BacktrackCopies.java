package com.kodilla.sudoku;

public class BacktrackCopies {
    private static BacktrackCopies backtrackCopiesInstance = null;
    private SudokuBoard[] backtrack;

    private BacktrackCopies() {
        this.backtrack = new SudokuBoard[1];
    }

    public SudokuBoard[] getBacktrack() {
        return backtrack;
    }

    public static BacktrackCopies getInstance(){
        if(backtrackCopiesInstance == null){
            backtrackCopiesInstance = new BacktrackCopies();
        }
        return backtrackCopiesInstance;
    }

}
