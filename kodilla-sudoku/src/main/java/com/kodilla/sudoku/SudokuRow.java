package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> sudokuRow;

    public SudokuRow() {
        this.sudokuRow = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            sudokuRow.add(new SudokuElement());
        }
    }

    public List<SudokuElement> getSudokuRow() {
        return sudokuRow;
    }

    @Override
    public String toString() {
        return "SudokuRow{" +
                "sudokuRow=" + sudokuRow +
                '}';
    }
}
