package com.kodilla.sudoku;

import java.util.*;

public class SudokuElement {
    public static final String EMPTY = "x";
    private String value;
    private Set<String> possilbeValues;

    public SudokuElement() {
        this.value = EMPTY;
        this.possilbeValues = new HashSet<>();
    }

    public String getValue() {
        return value;
    }

    public Set<String> getPossilbeValues() {
        return possilbeValues;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPossilbeValues(Set<String> possilbeValues) {
        this.possilbeValues = possilbeValues;
    }

    @Override
    public String toString() {
        return "SudokuElement{" +
                "value='" + value + '\'' +
                ", " + possilbeValues +
                '}';
    }
}
