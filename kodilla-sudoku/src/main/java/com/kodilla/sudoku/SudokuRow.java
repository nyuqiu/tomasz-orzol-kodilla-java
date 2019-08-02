package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private List<SudokuElement> sudokuElements = new ArrayList<>(addElements());

    public SudokuRow() {}

    private List<SudokuElement> addElements() {
        List<SudokuElement> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            result.add(new SudokuElement());
        }
        return result;
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
