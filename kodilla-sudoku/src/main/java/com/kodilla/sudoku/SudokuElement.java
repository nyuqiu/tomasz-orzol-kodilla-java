package com.kodilla.sudoku;

import java.util.*;

public class SudokuElement {
    public static int EMPTY = -1;
    private int value;
    private Set<Integer> possilbeValues;

    public SudokuElement() {
        this.value = EMPTY;
        this.possilbeValues = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
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
}
