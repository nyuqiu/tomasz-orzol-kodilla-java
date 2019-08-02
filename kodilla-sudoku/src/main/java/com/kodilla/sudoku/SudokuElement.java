package com.kodilla.sudoku;

import java.util.*;

public class SudokuElement {
    public static final String EMPTY = "x";
    private String value;
    private Set<String> possibleValues;

    public SudokuElement() {
        this.value = EMPTY;
        this.possibleValues = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
    }

    public String getValue() {
        return value;
    }

    public Set<String> getPossibleValues() {
        return possibleValues;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPossibleValues(Set<String> possibleValues) {
        this.possibleValues = possibleValues;
    }

    @Override
    public String toString() {
        return "SudokuElement{" +
                "value='" + value + '\'' +
                ", " + possibleValues +
                '}';
    }
}
