package com.kodilla.sudoku;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board extends Prototype {
    private static Board boardInstance = null;
    private List<Row> columns = new ArrayList<>(addRows());
    private Map<String, Set<Element>> partsByName = new HashMap<>(addPartsByName());
    private Set<String> boardValues = new HashSet<>();

    public Board() {
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board clonedBoard = (Board) super.clone();
        clonedBoard.columns = new ArrayList<>();
        for (Row theRow : columns) {
            Row clonedRow = new Row();
            clonedRow.getSudokuElements().clear();
            for (Element element : theRow.getSudokuElements()) {
                clonedRow.getSudokuElements().add(element.deepCopy());
            }
            clonedBoard.getColumns().add(clonedRow);
        }
        clonedBoard.partsByName = new HashMap<>(addPartsByName());
        clonedBoard.boardValues = new HashSet<>(getBoardValues());
        return clonedBoard;
    }

    public void repopulateValuesInOneOfNine() {
        partsByName.clear();
        partsByName = new HashMap<>(addPartsByName());
    }

    private Map<String, Set<Element>> addPartsByName() {
        return new HashMap<String, Set<Element>>() {{
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

    private List<Row> addRows() {
        List<Row> result = new ArrayList<>();
        IntStream.range(0, 9).forEach(n -> result.add(new Row()));
        return result;
    }

    public Set<String> getBoardValues() {
        return new HashSet<String>() {{
            for (int column = 0; column < 9; column++) {
                for (int row = 0; row < 9; row++) {
                    add(fieldByColumnAndRow(column, row).getValue());
                }
            }
        }};
    }

    public List<Row> getColumns() {
        return columns;
    }

    public Set<String> getColumnValues(int column) {
        Set<String> set = new HashSet<>();
        IntStream.range(0, 9).forEach(row -> set.add(fieldByColumnAndRow(column, row).getValue()));
        set.remove(Element.EMPTY);
        return set;
    }

    public Set<String> getRowValues(int row) {
        Set<String> set = new HashSet<>();
        IntStream.range(0, 9).forEach(column -> set.add(fieldByColumnAndRow(column, row).getValue()));
        set.remove(Element.EMPTY);
        return set;
    }

    public Set<String> getValuesFromOneOfNine(int column, int row) {
        return new HashSet<>(checkWhichPartOfBoard(column, row)).stream()
                .map(Element::getValue)
                .filter(n -> !Objects.equals(n, Element.EMPTY))
                .collect(Collectors.toSet());
    }

    public Set<Element> getElementsFromOneOfNine(int column, int row) {
        return new HashSet<>(checkWhichPartOfBoard(column, row));
    }

    public Set<Element> getColumnElements(int column) {
        Set<Element> set = new HashSet<>();
        IntStream.range(0, 9).forEach(row -> set.add(fieldByColumnAndRow(column, row)));
        return set;
    }

    public Set<Element> getRowElements(int row) {
        Set<Element> set = new HashSet<>();
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

    public Element fieldByColumnAndRow(int column, int row) {
        return getColumns().get(column).getSudokuElements().get(row);
    }


    public static Board getInstance() {
        if (boardInstance == null) {
            boardInstance = new Board();
        }
        return boardInstance;
    }

    private Set<Element> addElementsFromOneOfNine(int fromColumn, int toColumn, int fromRow, int toRow) {
        Set<Element> result = new HashSet<>();
        for (int column = fromColumn; column <= toColumn; column++) {
            for (int row = fromRow; row <= toRow; row++) {
                result.add(fieldByColumnAndRow(column, row));
            }
        }
        return result;
    }

    public Set<Element> checkWhichPartOfBoard(int column, int row) {
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
        Board that = (Board) o;
        return Objects.equals(columns, that.columns) &&
                Objects.equals(partsByName, that.partsByName) &&
                Objects.equals(boardValues, that.boardValues);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columns, partsByName, boardValues);
    }

    public void fillTheSudokuBoard(Board board, int columnMax, int rowMax) {
        for (int columnNumber = 0; columnNumber < columnMax; columnNumber++) {
            for (int rowNumber = 0; rowNumber < rowMax; rowNumber++) {

                if (columnNumber == 0 || columnNumber == 3 || columnNumber == 6) {
                    addingCorrectValueToBoard(board, columnNumber, rowNumber, 1);
                } else if (columnNumber == 1 || columnNumber == 4 || columnNumber == 7) {
                    if (rowNumber < 6) {
                        addingCorrectValueToBoard(board, columnNumber, rowNumber, 4);
                    } else
                        addingCorrectValueToBoard(board, columnNumber, rowNumber, -5);
                } else if (columnNumber == 2 || columnNumber == 5 || columnNumber == 8) {
                    if (rowNumber < 3) {
                        addingCorrectValueToBoard(board, columnNumber, rowNumber, 7);
                    } else
                        addingCorrectValueToBoard(board, columnNumber, rowNumber, -2);
                }
            }
        }
    }

    private void addingCorrectValueToBoard(Board board, int columnNumber, int rowNumber, int modifyByThis) {
        board.setValue(columnNumber, rowNumber, Integer.toString(biggerThanNine(rowNumber + modifyByThis + columnNumber / 3)));
    }

    private int biggerThanNine(int value) {
        return value < 10 ? value : value - 9;
    }
}