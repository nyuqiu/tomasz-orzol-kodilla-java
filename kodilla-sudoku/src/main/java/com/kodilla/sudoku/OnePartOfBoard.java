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

    public Set<Integer> valuesFromOneOfNine() {
        SudokuBoard sudokuBoard = SudokuBoard.getInstance();
        Set<Integer> values = new HashSet<>();

        for (; this.fromColumn <= this.toColumn; this.fromColumn++) {
            for (; this.fromRow <= this.toRow; this.fromRow++) {
                values.add(sudokuBoard.fieldByColumnAndRow(fromColumn, fromRow).getValue());
            }
        }
        return values;
    }

    public OnePartOfBoard checkWhichPartOfBoard(int column, int row) {
        if (0 <= column && column <= 2) {
            return checkForRow(0, 2, row);
        } else if (3 <= column && column <= 5) {
            return checkForRow(3, 5, row);
        } else if (6 <= column && column <= 8) {
            return checkForRow(6, 8, row);
        } else {
            return null;
        }
    }

    private OnePartOfBoard checkForRow(int columnMinNumber, int columnMaxNumber, int rowNumber) {
        if (0 <= rowNumber && rowNumber <= 2) {
            return new OnePartOfBoard(columnMinNumber, columnMaxNumber, 0, 2);
        } else if (3 <= rowNumber && rowNumber <= 5) {
            return new OnePartOfBoard(columnMinNumber, columnMaxNumber, 3, 5);
        } else if (6 <= rowNumber && rowNumber <= 8) {
            return new OnePartOfBoard(columnMinNumber, columnMaxNumber, 6, 8);
        } else {
            return null;
        }
    }
}
