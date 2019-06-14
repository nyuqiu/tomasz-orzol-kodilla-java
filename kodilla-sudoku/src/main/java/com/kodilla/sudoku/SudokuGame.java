package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuGame {
    private BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
    private AvailableValues availableValues = new AvailableValues();

    public boolean resolveSudoku(SudokuBoard sudokuBoard) {
        SudokuElement sudokuElement;
        backtrackCopies.getBacktrack().add(sudokuBoard);
        for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
            for (int rowNumber = 0; rowNumber < 9; rowNumber++) {
                availableValues.availableValuesForField(sudokuBoard);
                sudokuElement = sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber);
                List<Integer> onePossibleElement = new ArrayList<>(sudokuElement.getPossilbeValues());
                if (sudokuElement.getValue() == SudokuElement.EMPTY) {
                    if (sudokuElement.getPossilbeValues().size() == 1) {
                        sudokuElement.setValue(onePossibleElement.get(0));
                        availableValues.availableValuesForField(sudokuBoard);
                    } else if (sudokuElement.getPossilbeValues().size() == 0) {
                        availableValues.removeUnsolvableSudoku();
                    } while (sudokuElement.getPossilbeValues().size() > 1) {
                        backtrackCopies.getBacktrack().add(sudokuBoard);
                        sudokuElement.setValue(onePossibleElement.get(0));
                        availableValues.availableValuesForField(sudokuBoard);
                    }
                }
            }
        }
        return true;
    }
}

