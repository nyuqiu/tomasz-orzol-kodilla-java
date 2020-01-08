package com.kodilla.sudoku;

import java.util.*;

public class SudokuBoard extends Prototype {
    private int columns = 9;
    private int rows = 9;
    private static SudokuBoard sudokuBoardInstance = null;
    private List<SudokuRow> sudokuColumns = new ArrayList<>(addRows());
    private Map<String, Set<SudokuElement>> partsByName = new HashMap<>(addPartsByName());
    private Set<String> boardValues = new HashSet<>(addBoardValues());

    public SudokuBoard() {}

    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard) super.clone();
        clonedBoard.sudokuColumns = new ArrayList<>();
        for (SudokuRow theSudokuRow : sudokuColumns) {
            SudokuRow clonedRow = new SudokuRow();
            clonedRow.getSudokuElements().clear();
            for (SudokuElement sudokuElement : theSudokuRow.getSudokuElements()) {
                clonedRow.getSudokuElements().add(sudokuElement.deepCopy());
            }
            clonedBoard.getSudokuColumns().add(clonedRow);
        }
        clonedBoard.partsByName = new HashMap<>(addPartsByName());
        clonedBoard.boardValues = new HashSet<>(addBoardValues());
        return clonedBoard;
    }

    private Map<String, Set<SudokuElement>> addPartsByName() {
        return new HashMap<String, Set<SudokuElement>>() {{
            put("topLeft", addElementsFromOneOfNine(0, 2, 0, 2));
            put("topCentre", addElementsFromOneOfNine(3, 5, 0, 2));
            put("topRight", addElementsFromOneOfNine(6, 8, 0, 2));
            put("centreLeft", addElementsFromOneOfNine(0, 2, 3, 5));
            put("centreCentre", addElementsFromOneOfNine(3, 5, 3, 5));
            put("centreRight", addElementsFromOneOfNine(6, 8, 3, 5));
            put("bottomLeft", addElementsFromOneOfNine(0, 2, 6, 8));
            put("bottomCentre", addElementsFromOneOfNine(3, 5, 6, 8));
            put("bottomRight", addElementsFromOneOfNine(6, 8, 6, 8));
        }};
    }

    private List<SudokuRow> addRows() {
        List<SudokuRow> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            result.add(new SudokuRow());
        }
        return result;
    }

    private Set<String> addBoardValues() {
        return new HashSet<String>() {{
            for (int column = 0; column <= 8; column++) {
                for (int row = 0; row <= 8; row++) {
                    add(fieldByColumnAndRow(column, row).getValue());
                }
            }
        }};
    }

    public Set<String> getBoardValues() {
        return boardValues;
    }

    public List<SudokuRow> getSudokuColumns() {
        return sudokuColumns;
    }

    public Set<String> getColumnValuesByColumnNumber(int column) {
        Set<String> set = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            set.add(fieldByColumnAndRow(column, row).getValue());
        }
        set.remove(SudokuElement.EMPTY);
        return set;
    }

    public Set<String> getRowValuesByRowNumber(int row) {
        Set<String> set = new HashSet<>();
        for (int column = 0; column < 9; column++) {
            set.add(fieldByColumnAndRow(column, row).getValue());
        }
        set.remove(SudokuElement.EMPTY);
        return set;
    }

    public Set<String> getValuesFromOneOfNine(int column, int row) {
        Set<String> set = new HashSet<>();
        checkWhichPartOfBoard(column, row).forEach(n -> set.add(n.getValue()));
        set.remove(SudokuElement.EMPTY);
        return set;
    }

    public void setValue(int column, int row, String value) {
        if (!(getColumnValuesByColumnNumber(column).contains(value)) &&
                !(getRowValuesByRowNumber(row).contains(value)) &&
                !(getValuesFromOneOfNine(column, row).contains(value))) {
            fieldByColumnAndRow(column, row).setValue(value);
        } else {
            System.out.println("Cannot add this value");
        }
    }

    public SudokuElement fieldByColumnAndRow(int column, int row) {
        return getSudokuColumns().get(column).getSudokuElements().get(row);
    }


    public static SudokuBoard getInstance() {
        if (sudokuBoardInstance == null) {
            sudokuBoardInstance = new SudokuBoard();
        }
        return sudokuBoardInstance;
    }

    private Set<SudokuElement> addElementsFromOneOfNine(int fromColumn, int toColumn, int fromRow, int toRow) {
        Set<SudokuElement> result = new HashSet<>();
        for (int column = fromColumn; column <= toColumn; column++) {
            for (int row = fromRow; row <= toRow; row++) {
                result.add(fieldByColumnAndRow(column, row));
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
        return Objects.equals(sudokuColumns, that.sudokuColumns) &&
                Objects.equals(partsByName, that.partsByName) &&
                Objects.equals(boardValues, that.boardValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sudokuColumns, partsByName, boardValues);
    }
}