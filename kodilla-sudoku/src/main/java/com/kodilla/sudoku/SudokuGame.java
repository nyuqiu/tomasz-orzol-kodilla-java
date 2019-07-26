package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuGame {
    private BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
    private AvailableValues availableValues = new AvailableValues();

    public boolean resolveSudoku(SudokuBoard sudokuBoard) {

        System.out.println("save copy");
        try {
            backtrackCopies.getBacktrack().add(sudokuBoard.deepCopy());
        } catch (Exception e){

        }

        for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
            for (int rowNumber = 0; rowNumber < 9; rowNumber++) {

                availableValues.availableValuesForField();
                SudokuElement sudokuElement = sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber);
                List<String> onePossibleElement = new ArrayList<>(sudokuElement.getPossilbeValues());
                if (sudokuElement.getValue().contains(SudokuElement.EMPTY)) {
                    if (sudokuElement.getPossilbeValues().size() == 1) {
                        sudokuElement.setValue(onePossibleElement.get(0));
                        availableValues.availableValuesForField();
                    } else if (sudokuElement.getPossilbeValues().size() == 0) {
                        availableValues.removeUnsolvableSudoku();
                    } while (sudokuElement.getPossilbeValues().size() > 1) {
                        System.out.println("save copy");
                        backtrackCopies.getBacktrack().add(sudokuBoard);
                        sudokuElement.setValue(onePossibleElement.get(0));
                        availableValues.availableValuesForField();
                    }
                }
            }
        }
        return true;
    }
}

