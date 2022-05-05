package com.kodilla.sudoku;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuBoard extends Prototype {
    private static SudokuBoard sudokuBoardInstance = null;
    private List<SudokuRow> sudokuColumns = new ArrayList<>(addRows());
    private Map<String, Set<SudokuElement>> partsByName = new HashMap<>(addPartsByName());
    private Set<String> boardValues = new HashSet<>();

    public SudokuBoard() {
    }

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
        clonedBoard.boardValues = new HashSet<>(getBoardValues());
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
        IntStream.range(0, 9).forEach(n -> result.add(new SudokuRow()));
        return result;
    }

    public Set<String> getBoardValues() {
        Set<String> set = new HashSet<>();
        IntStream.range(0, 9).boxed()
                .map(column -> IntStream.range(0, 9)
                        .mapToObj(row -> set.add(fieldByColumnAndRow(column, row).getValue())));
        return set;
    }

    public List<SudokuRow> getSudokuColumns() {
        return sudokuColumns;
    }

    public Set<String> getColumnValues(int column) {
        Set<String> set = new HashSet<>();
        IntStream.range(0, 9).forEach(row -> set.add(fieldByColumnAndRow(column, row).getValue()));
        set.remove(SudokuElement.EMPTY);
        return set;
    }

    public Set<String> getRowValues(int row) {
        Set<String> set = new HashSet<>();
        IntStream.range(0, 9).forEach(column -> set.add(fieldByColumnAndRow(column, row).getValue()));
        set.remove(SudokuElement.EMPTY);
        return set;
    }

    public Set<String> getValuesFromOneOfNine(int column, int row) {
        return new HashSet<>(checkWhichPartOfBoard(column, row)).stream()
                .map(SudokuElement::getValue)
                .filter(n -> !Objects.equals(n, SudokuElement.EMPTY))
                .collect(Collectors.toSet());
    }

    public Set<SudokuElement> getElementsFromOneOfNine(int column, int row) {
        return new HashSet<>(checkWhichPartOfBoard(column, row));
    }

    public Set<SudokuElement> getColumnElements(int column) {
        Set<SudokuElement> set = new HashSet<>();
        IntStream.range(0, 9).forEach(row -> set.add(fieldByColumnAndRow(column, row)));
        return set;
    }

    public Set<SudokuElement> getRowElements(int row) {
        Set<SudokuElement> set = new HashSet<>();
        IntStream.range(0, 9).forEach(column -> set.add(fieldByColumnAndRow(column, row)));
        return set;
    }

    public void setValue(int column, int row, String value) {
        if (!(getColumnValues(column).contains(value)) &&
                !(getRowValues(row).contains(value)) &&
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

    public void fillTheSudokuBoard(SudokuBoard sudokuBoard, int columnMax, int rowMax) {
        for (int columnNumber = 0; columnNumber < columnMax; columnNumber++) {
            for (int rowNumber = 0; rowNumber < rowMax; rowNumber++) {

                if (columnNumber == 0 || columnNumber == 3 || columnNumber == 6) {
                    addingCorrectValueToBoard(sudokuBoard, columnNumber, rowNumber, 1);
                } else if (columnNumber == 1 || columnNumber == 4 || columnNumber == 7) {
                    if (rowNumber < 6) {
                        addingCorrectValueToBoard(sudokuBoard, columnNumber, rowNumber, 4);
                    } else
                        addingCorrectValueToBoard(sudokuBoard, columnNumber, rowNumber, -5);
                } else if (columnNumber == 2 || columnNumber == 5 || columnNumber == 8) {
                    if (rowNumber < 3) {
                        addingCorrectValueToBoard(sudokuBoard, columnNumber, rowNumber, 7);
                    } else
                        addingCorrectValueToBoard(sudokuBoard, columnNumber, rowNumber, -2);
                }
            }
        }
    }

    private void addingCorrectValueToBoard(SudokuBoard sudokuBoard, int columnNumber, int rowNumber, int modifyByThis) {
        sudokuBoard.setValue(columnNumber, rowNumber, Integer.toString(biggerThanNine(rowNumber + modifyByThis + columnNumber / 3)));
    }

    private int biggerThanNine(int value) {
        return value < 10 ? value : value - 9;
    }
}