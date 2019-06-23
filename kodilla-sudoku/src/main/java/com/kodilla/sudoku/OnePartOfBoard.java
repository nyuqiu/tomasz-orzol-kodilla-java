package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;

public class OnePartOfBoard {
    private int fromColumn;
    private int toColumn;
    private int fromRow;
    private int toRow;

    public OnePartOfBoard(int fromColumn, int toColumn, int fromRow, int toRow) {
        this.fromColumn = fromColumn;
        this.toColumn = toColumn;
        this.fromRow = fromRow;
        this.toRow = toRow;
    }

    public Set<String> valuesFromOneOfNine() {
        SudokuBoard sudokuBoard = SudokuBoard.getInstance();
        Set<String> values = new HashSet<>();

        for (; this.fromColumn <= this.toColumn; this.fromColumn++) {
            for (; this.fromRow <= this.toRow; this.fromRow++) {
                values.add(sudokuBoard.fieldByColumnAndRow(fromColumn, fromRow).getValue());
            }
        }
        return values;
    }
}
