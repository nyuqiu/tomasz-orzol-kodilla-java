package com.kodilla.sudoku;

import java.util.*;

public class SudokuBoard {
    private static SudokuBoard sudokuBoardInstance = null;
    private List<SudokuRow> sudokuColumns;
    private final Map<String, Set<SudokuElement>> partsByName = new HashMap<String, Set<SudokuElement>>() {
        {
            put("topLeft", addElementsFromOneOfNine(0, 2, 0, 2));
            put("topCentre", addElementsFromOneOfNine(3, 5, 0, 2));
            put("topRight", addElementsFromOneOfNine(6, 8, 0, 2));
            put("centreLeft", addElementsFromOneOfNine(0, 2, 3, 5));
            put("centreCentre", addElementsFromOneOfNine(3, 5, 3, 5));
            put("centreRight", addElementsFromOneOfNine(6, 8, 3, 5));
            put("bottomLeft", addElementsFromOneOfNine(0, 2, 6, 8));
            put("bottomCentre", addElementsFromOneOfNine(3, 5, 6, 8));
            put("bottomRight", addElementsFromOneOfNine(6, 8, 6, 8));

        }
    };

    public SudokuBoard() {
        this.sudokuColumns = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            sudokuColumns.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getSudokuColumns() {
        return sudokuColumns;
    }

    public List<String> getColumnValuesByColumnNumber(int column) {
        List<String> list = new ArrayList<>();
        for (int row = 0; row < 9; row++) {
            list.add(fieldByColumnAndRow(column, row).getValue());
        }
        return list;
    }

    public List<String> getRowValuesByRowNumber(int row) {
        List<String> list = new ArrayList<>();
        for (int column = 0; column < 9; column++) {
            list.add(fieldByColumnAndRow(column, row).getValue());
        }
        return list;
    }

    public List<String> getValuesFromOneOfNine(int column, int row) {
        List<String> list = new ArrayList<>();
        checkWhichPartOfBoard(column, row).forEach(n-> list.add(n.getValue()));
        return list;
    }

    public void setValue(int column, int row, String value) {
        System.out.println("Test test test " + getValuesFromOneOfNine(column, row));
        if (!(getColumnValuesByColumnNumber(column).contains(value)) &&
                !(getRowValuesByRowNumber(row).contains(value)) &&
                !(getValuesFromOneOfNine(column, row).contains(value))) {
            fieldByColumnAndRow(column, row).setValue(value);
        } else {
            System.out.println("Cannot add this value");
        }
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

    private Set<SudokuElement> addElementsFromOneOfNine(int fromColumn, int toColumn, int fromRow, int toRow) {
        Set<SudokuElement> result = new HashSet<>();
        for (; fromColumn <= toColumn; fromColumn++) {
            for (; fromRow <= toRow; toRow++) {
                result.add(fieldByColumnAndRow(fromColumn, fromRow));
            }
        }
        return result;
    }

    public Set<SudokuElement> checkWhichPartOfBoard(int column, int row) {
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
        String result = "";
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                result += "  " + fieldByColumnAndRow(column, row).getValue() + "  ";
            }
            result += "\n";
        }
        return result;
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
}