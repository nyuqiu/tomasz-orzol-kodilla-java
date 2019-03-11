package com.kodilla.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AvaiableValues {
    public final String VALUEEXIST = "Cannot add, number exist in row, columns, or in one of nine part.";

    public void avaiableValuesForField(SudokuBoard sudokuBoard) {
        Set<Integer> usedValues = new HashSet<>();
        for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
            for (int rowNumber = 0; rowNumber < 9; rowNumber++) {
                SudokuElement sudokuElement = sudokuBoard.getSudokuColumns().get(columnNumber).getSudokuRow().get(rowNumber);
                if (sudokuElement.getValue() == SudokuElement.EMPTY) {
                    for (int numbersFromColumns = 0; numbersFromColumns < 9; numbersFromColumns++) {
                        if (usedValues.contains(sudokuElement.getValue()) && sudokuElement.getValue() > 0) {
                            sudokuBoard = trueForDuplicatedValues();
                        } else {
                            usedValues.add(sudokuBoard.getSudokuColumns().get(numbersFromColumns).getSudokuRow().get(rowNumber).getValue());
                        }
                    }
                    for (int numbersFromRows = 0; numbersFromRows < 9; numbersFromRows++) {
                        if (usedValues.contains(sudokuElement.getValue()) && sudokuElement.getValue() > 0) {
                            sudokuBoard = trueForDuplicatedValues();
                        } else {
                            usedValues.add(sudokuBoard.getSudokuColumns().get(columnNumber).getSudokuRow().get(numbersFromRows).getValue());
                        }
                    }
                    if (sudokuBoard.getValuesFromOneOfNineParts(columnNumber, rowNumber).contains(sudokuElement.getValue()) && sudokuElement.getValue() > 0) {
                        System.out.println(VALUEEXIST);
                        sudokuBoard = Arrays.asList(BacktrackCopies.getInstance().getBacktrack()).get(0);
                    } else {
                        usedValues.addAll(sudokuBoard.getValuesFromOneOfNineParts(columnNumber, rowNumber));
                    }
                    usedValues.remove(SudokuElement.EMPTY);
                    sudokuElement.setPossilbeValues(usedValues);
                }
            }
        }
    }
    public SudokuBoard trueForDuplicatedValues(){
        SudokuBoard sudokuBoard;
        System.out.println(VALUEEXIST);
        sudokuBoard = Arrays.asList(BacktrackCopies.getInstance().getBacktrack()).get(0);
        return sudokuBoard;
    }
}

