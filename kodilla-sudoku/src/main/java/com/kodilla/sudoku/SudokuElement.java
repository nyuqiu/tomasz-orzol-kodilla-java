package com.kodilla.sudoku;

import java.util.*;

public class SudokuElement extends Prototype {
    public static final String EMPTY = "x";
    private String value;
    private List<String> possibleValues;

    public SudokuElement() {
        this.value = EMPTY;
        this.possibleValues = new ArrayList<>();
    }

    public SudokuElement deepCopy() throws CloneNotSupportedException {
        SudokuElement clonedElement = (SudokuElement) super.clone();
        clonedElement.value = value;
        clonedElement.possibleValues = possibleValues;
        return clonedElement;
    }

    public String getValue() {
        return value;
    }

    public List<String> getPossibleValues() {
        return possibleValues;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPossibleValues(List<String> values) {
        this.possibleValues = values;
    }

    @Override
    public String toString() {
        return "SudokuElement{" +
                "value='" + value + '\'' +
                ", " + possibleValues +
                '}';
    }
}
