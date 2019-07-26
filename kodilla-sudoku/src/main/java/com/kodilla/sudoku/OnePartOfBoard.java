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

    public Set<SudokuElement> valuesFromOneOfNine(SudokuBoard sudokuBoard) {
        Set<SudokuElement> values = new HashSet<>();

        int count = 0;
        for (; this.fromColumn <= this.toColumn; this.fromColumn++) {
            for (; this.fromRow <= this.toRow; this.fromRow++) {
                System.out.println("column " + this.fromColumn + " row " + this.fromRow + " value " + sudokuBoard.fieldByColumnAndRow(fromColumn, fromRow).getValue() + " " + count++);
                values.add(sudokuBoard.fieldByColumnAndRow(fromColumn, fromRow));
            }
        }
        return values;
    }
}
