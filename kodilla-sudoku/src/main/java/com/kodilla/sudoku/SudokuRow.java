package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> sudokuElements;

    public SudokuRow() {
        this.sudokuElements = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            sudokuElements.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getSudokuElements() {
        return sudokuElements;
    }

    @Override
    public String toString() {
        return "SudokuRow{" +
                "sudokuElements=" + sudokuElements +
                '}';
    }
}
