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


//    private OnePartOfBoard topLeft = new OnePartOfBoard(0, 2, 0, 2);
//    private OnePartOfBoard topCentre = new OnePartOfBoard(0, 2, 3, 5);
//    private OnePartOfBoard topRight = new OnePartOfBoard(0, 2, 6, 8);
//    private OnePartOfBoard centreLeft = new OnePartOfBoard(3, 5, 0, 2);
//    private OnePartOfBoard centreCentre = new OnePartOfBoard(3, 5, 3, 5);
//    private OnePartOfBoard centreRight = new OnePartOfBoard(3, 5, 6, 8);
//    private OnePartOfBoard bottomLeft = new OnePartOfBoard(6, 8, 0, 2);
//    private OnePartOfBoard bottomCentre = new OnePartOfBoard(6, 8, 3, 5);
//    private OnePartOfBoard bottomRight = new OnePartOfBoard(6, 8, 6, 8);


    private SudokuBoard() {
        this.sudokuColumns = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            sudokuColumns.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getSudokuColumns() {
        return sudokuColumns;
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

    private Set<Integer> addValuesFromOneOfNine(int fromColumnNumber, int toColumnNumber, int fromRowNumber,
                                                int toRowNumber) {
        Set<Integer> valuesFromOneOfNine = new HashSet<>();
        for (; fromColumnNumber < toColumnNumber; fromColumnNumber++) {
            for (; fromRowNumber < toRowNumber; fromRowNumber++) {
                if (valuesFromOneOfNine.contains(fieldByColumnAndRow(fromColumnNumber, fromRowNumber).getValue())) {
                    System.out.println(Messages.VALUEEXIST);
                } else {
                    valuesFromOneOfNine.add(fieldByColumnAndRow(fromColumnNumber, fromRowNumber).getValue());
                }
            }
        }
        return valuesFromOneOfNine;
    }

    public OnePartOfBoard checkWhichPartOfBoard(int column, int row) {
        String fullNameOneOfNine;
        if (0 <= row && row <= 2) {
            fullNameOneOfNine = "top" + checkForRow(column);
        } else if (3 <= row && row <= 5) {
            fullNameOneOfNine = "centre" + checkForRow(column);
        } else if (6 <= row && row <= 8) {
            fullNameOneOfNine = "right" + checkForRow(column);
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


    public Set<Integer> getValuesFromOneOfNineParts(int column, int row) {
        if (0 <= column && column <= 2) {
            return whichRow(0, 2, row);
        } else if (3 <= column && column <= 5) {
            return whichRow(3, 5, row);
        } else if (6 <= column && column <= 8) {
            return whichRow(6, 8, row);
        } else {
            return null;
        }
    }

    private Set<Integer> whichRow(int columnMinNumber, int columnMaxNumber, int rowNumber) {
        if (0 <= rowNumber && rowNumber <= 2) {
            return addValuesFromOneOfNine(columnMinNumber, columnMaxNumber, 0, 2);
        } else if (3 <= rowNumber && rowNumber <= 5) {
            return addValuesFromOneOfNine(columnMinNumber, columnMaxNumber, 3, 5);
        } else if (6 <= rowNumber && rowNumber <= 8) {
            return addValuesFromOneOfNine(columnMinNumber, columnMaxNumber, 6, 8);
        } else {
            return null;
        }
    }
}