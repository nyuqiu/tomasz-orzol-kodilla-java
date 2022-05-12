package com.kodilla.sudoku;

public class StarterDto {
    int columns;
    int rows;
    String name;

    public StarterDto(int columns, int rows, String name) {
        this.columns = columns;
        this.rows = rows;
        this.name = name;
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public String getName() {
        return name;
    }
}
