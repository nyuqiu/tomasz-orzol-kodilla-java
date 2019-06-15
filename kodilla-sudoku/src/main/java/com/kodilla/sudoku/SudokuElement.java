package com.kodilla.sudoku;

import java.util.*;

public class SudokuElement {
    public static final int EMPTY = -1;
    private int value;
    private Set<Integer> possilbeValues;

    public SudokuElement() {
        this.value = EMPTY;
        this.possilbeValues = new HashSet<>();
    }

    public int getValue() {
        return value;
    }

    public Set<Integer> getPossilbeValues() {
        return possilbeValues;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPossilbeValues(Set<Integer> possilbeValues) {
        this.possilbeValues = possilbeValues;
    }

    @Override
    public String toString() {
        return "SudokuElement{" +
                "value=" + value +
                ", possilbeValues=" + possilbeValues +
                '}';
    }
}
