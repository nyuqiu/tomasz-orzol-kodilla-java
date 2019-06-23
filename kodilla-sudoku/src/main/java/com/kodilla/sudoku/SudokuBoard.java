package com.kodilla.sudoku;

import java.util.*;

public class SudokuBoard {
    private static SudokuBoard sudokuBoardInstance = null;
    private List<SudokuRow> sudokuColumns;
    private final Map<String, OnePartOfBoard> partsByName = new HashMap<String, OnePartOfBoard>() {
        {
            put("topLeft", new OnePartOfBoard(0, 2, 0, 2));
            put("topCentre", new OnePartOfBoard(0, 2, 6, 8));
            put("topRight", new OnePartOfBoard(0, 2, 0, 2));
            put("centreLeft", new OnePartOfBoard(3, 5, 0, 2));
            put("centreCentre", new OnePartOfBoard(3, 5, 3, 5));
            put("centreRight", new OnePartOfBoard(3, 5, 6, 8));
            put("bottomLeft", new OnePartOfBoard(6, 8, 0, 2));
            put("bottomCentre", new OnePartOfBoard(6, 8, 3, 5));
            put("bottomRight", new OnePartOfBoard(6, 8, 6, 8));
        }
    };
    private final Map<Integer, List<SudokuElement>> rowsValues = new HashMap<>();
    private final Map<Integer, List<SudokuElement>> columnsValues = new HashMap<>();


    private SudokuBoard() {
        this.sudokuColumns = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            sudokuColumns.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getSudokuColumns() {
        return sudokuColumns;
    }

    public void setSudokuColumns(List<SudokuRow> sudokuColumns) {
        this.sudokuColumns = sudokuColumns;
    }

    public void setValue(int column, int row, String value) {
        getSudokuColumns().get(column).getSudokuRow().get(row).setValue(value);
    }

    public SudokuElement fieldByColumnAndRow(int column, int row) {
        return getSudokuColumns().get(column).getSudokuRow().get(row);
    }

    public static SudokuBoard getInstance() {
        if (sudokuBoardInstance == null) {
            sudokuBoardInstance = new SudokuBoard();
        }
        return sudokuBoardInstance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SudokuBoard that = (SudokuBoard) o;
        return Objects.equals(sudokuColumns, that.sudokuColumns);
    }


    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard) super.clone();
        clonedBoard.sudokuColumns = new ArrayList<>();
        for (SudokuRow clonedRows : sudokuColumns) {
            SudokuRow clonedRow = new SudokuRow();
            for (SudokuElement sudokuElement : clonedRows.getSudokuRow()) {
                clonedRow.getSudokuRow().add(sudokuElement);
            }
            clonedBoard.getSudokuColumns().add(clonedRow);
        }
        return clonedBoard;
    }

    public OnePartOfBoard checkWhichPartOfBoard(int column, int row) {
        String fullNameOneOfNine;
        if (0 <= row && row <= 2) {
            fullNameOneOfNine = "top" + checkForRow(column);
        } else if (3 <= row && row <= 5) {
            fullNameOneOfNine = "centre" + checkForRow(column);
        } else if (6 <= row && row <= 8) {
            fullNameOneOfNine = "bottom" + checkForRow(column);
        } else {
            return null;
        }
        return partsByName.get(fullNameOneOfNine);
    }

    private String checkForRow(int column) {
        if (0 <= column && column <= 2) {
            return "Left";
        } else if (3 <= column && column <= 5) {
            return "Centre";
        } else if (6 <= column && column <= 8) {
            return "Right";
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "SudokuBoard{" +
                "sudokuColumns=" + sudokuColumns +
                ", partsByName=" + partsByName +
                '}';
    }


    public void populateColumnsAndRowsValues() {
        for (int column = 0; column < 9; column++) {
            columnsValues.put(column, valuesByColumns(column));
        }
        for (int row = 0; row < 9; row++) {
            columnsValues.put(row, valuesByRows(row));
        }
    }

    public Map<Integer, List<SudokuElement>> getColumnsValues() {
        return columnsValues;
    }

    private List<SudokuElement> valuesByColumns(int column) {
        List<SudokuElement> results = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            results.add(fieldByColumnAndRow(column, row));
        }
        return results;
    }

    private List<SudokuElement> valuesByRows(int row) {
        List<SudokuElement> results = new ArrayList<>();
        for (int column = 0; column < 9; column++) {
            results.add(fieldByColumnAndRow(column, row));
        }
        return results;
    }
}