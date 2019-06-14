package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class BacktrackCopies {
    private static BacktrackCopies backtrackCopiesInstance = null;
    private List<SudokuBoard> backtrack;

    private BacktrackCopies() {
        this.backtrack = new ArrayList<>();
    }

    public List<SudokuBoard> getBacktrack() {
        return backtrack;
    }

    public static BacktrackCopies getInstance(){
        if(backtrackCopiesInstance == null){
            backtrackCopiesInstance = new BacktrackCopies();
        }
        return backtrackCopiesInstance;
    }

}
