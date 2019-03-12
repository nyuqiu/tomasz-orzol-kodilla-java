package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuBoard {
    public final String VALUEEXIST = "Cannot add, number exist in row, columns, or in one of nine part.";
    private static SudokuBoard sudokuBoardInstance = null;
    private List<SudokuRow> sudokuColumns;

    public SudokuBoard() {
        this.sudokuColumns = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            sudokuColumns.add(new SudokuRow());
        }
    }

    public List<SudokuRow> getSudokuColumns() {
        return sudokuColumns;
    }

    public SudokuElement fieldByColumnAndRow(int column, int row){
        return getSudokuColumns().get(column).getSudokuRow().get(row);
    }

    public Set<Integer> getValuesFromOneOfNineParts(int column, int row) {
        if (column < 3) {
            return whichColumns(row);
        } else if (3 <= column && column < 6) {
            return whichColumns(row);
        } else if (6 <= column) {
            return whichColumns(row);
        } else {
            return null;
        }
    }

    public static SudokuBoard getInstance(){
        if(sudokuBoardInstance == null){
            sudokuBoardInstance = new SudokuBoard();
        }
        return sudokuBoardInstance;
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard) super.clone();
        clonedBoard.sudokuColumns = new ArrayList<>();
        for (SudokuRow clonedRows : sudokuColumns) {
            SudokuRow clonedRow = new SudokuRow();
            for (SudokuElement sudokuElement : clonedRows.getSudokuRow()){
                clonedRow.getSudokuRow().add(sudokuElement);
            }
            clonedBoard.getSudokuColumns().add(clonedRow);
        }
        return clonedBoard;
    }

    private Set<Integer> addValuesFromOneOfNine(int fromColumnNumber, int toColumnNumber, int fromRowNumber, int toRowNumber) {
        Set<Integer> valuesFromOneOfNine = new HashSet<>();
        for (; fromColumnNumber < toColumnNumber; fromColumnNumber++) {
            for (; fromRowNumber < toRowNumber; fromRowNumber++) {
                if (valuesFromOneOfNine.contains(fieldByColumnAndRow(fromColumnNumber, fromRowNumber).getValue())) {
                    System.out.println(VALUEEXIST);
                } else {
                    valuesFromOneOfNine.add(fieldByColumnAndRow(fromColumnNumber, fromRowNumber).getValue());
                }
            }
        }
        return valuesFromOneOfNine;
    }

    private Set<Integer> whichColumns(int columnNumber) {
        if (columnNumber < 3) {
            return addValuesFromOneOfNine(3, 6, 0, 3);
        } else if (2 < columnNumber && columnNumber < 6) {
            return addValuesFromOneOfNine(3, 6, 3, 6);
        } else if (6 <= columnNumber) {
            return addValuesFromOneOfNine(3, 6, 6, 9);
        } else {
            return null;
        }
    }
}

