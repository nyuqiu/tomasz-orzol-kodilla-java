package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class NinePartsOfBoards {
    private int fromColumn;
    private int toColumn;
    private int fromRow;
    private int toRow;

    public NinePartsOfBoards(int fromColumn, int toColumn, int fromRow, int toRow) {
        this.fromColumn = fromColumn;
        this.toColumn = toColumn;
        this.fromRow = fromRow;
        this.toRow = toRow;
    }

    public List<Integer> valuesFromOneOfNine() {
        SudokuBoard sudokuBoard = SudokuBoard.getInstance();
        List<Integer> values = new ArrayList<>();

        for (; this.fromColumn <= this.toColumn; this.fromColumn++) {
            for (; this.fromRow <= this.toRow; this.fromRow++) {
                values.add(sudokuBoard.fieldByColumnAndRow(fromColumn, fromRow).getValue());
            }
        }
        return values;
    }
}
