package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Element> elements = new ArrayList<>(addElements());

    public Row() {}

    private List<Element> addElements() {
        List<Element> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            result.add(new Element());
        }
        return result;
    }

    public List<Element> getSudokuElements() {
        return elements;
    }

    @Override
    public String toString() {
        return "Row{" +
                "elements=" + elements +
                '}';
    }
}
