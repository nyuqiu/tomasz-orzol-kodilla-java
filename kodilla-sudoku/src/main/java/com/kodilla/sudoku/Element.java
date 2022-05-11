package com.kodilla.sudoku;

import java.util.*;

public class Element extends Prototype {
    public static final String EMPTY = "x";
    private String value;
    private List<String> possibleValues;

    public Element() {
        this.value = EMPTY;
        this.possibleValues = new ArrayList<>();
    }

    public Element deepCopy() throws CloneNotSupportedException {
        Element clonedElement = (Element) super.clone();
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
        return "Element{" +
                "value='" + value + '\'' +
                ", " + possibleValues +
                '}';
    }
}
