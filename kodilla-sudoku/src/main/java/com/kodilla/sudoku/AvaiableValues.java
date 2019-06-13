package com.kodilla.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AvaiableValues {
    private SudokuBoard sudokuBoard;
    private Set<Integer> usedValues = new HashSet<>();
    private SudokuBoard oldSudokuBoard;
    private SudokuElement sudokuElement;

    public void avaiableValuesForField(SudokuBoard sudokuBoard) {

        for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
            for (int rowNumber = 0; rowNumber < 9; rowNumber++) {
                sudokuElement = sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber);
                if (sudokuElement.getValue() == SudokuElement.EMPTY) {
                    for (int columnIteration = 0; columnIteration < 9; columnIteration++) {
                        addPossibleNumber(columnIteration, rowNumber);
                    }
                    for (int rowIteration = 0; rowIteration < 9; rowIteration++) {
                        addPossibleNumber(columnNumber, rowIteration);
                    }
                    if (sudokuBoard.getValuesFromOneOfNineParts(columnNumber, rowNumber).contains(sudokuElement.getValue()) && sudokuElement.getValue() > 0) {
                        sudokuBoard = retrievePreviousBoard();
                    } else {
                        usedValues.addAll(sudokuBoard.getValuesFromOneOfNineParts(columnNumber, rowNumber));
                    }
                    usedValues.remove(SudokuElement.EMPTY);
                    sudokuElement.setPossilbeValues(usedValues);
                }
            }
        }
    }

    private void addPossibleNumber(int columnNumber, int rowNumber) {
        if (usedValues.contains(sudokuElement.getValue()) && !(sudokuElement.getValue() == SudokuElement.EMPTY)) {
            oldSudokuBoard = retrievePreviousBoard();
            if (!oldSudokuBoard.equals(sudokuBoard)) {
                sudokuBoard = oldSudokuBoard;
            } else {
                removeUnsolvableSudoku();
            }

        } else {
            usedValues.add(sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber).getValue());
        }
    }

    public SudokuBoard retrievePreviousBoard() {
        System.out.println(Messages.VALUEEXIST);
        sudokuBoard = Arrays.asList(BacktrackCopies.getInstance().getBacktrack()).get(0);
        return sudokuBoard;
    }

    public void removeUnsolvableSudoku() {
        System.out.println(Messages.CANNOTSOLVE);
        sudokuBoard = Arrays.asList(BacktrackCopies.getInstance().getBacktrack()).remove(0);
    }
}

