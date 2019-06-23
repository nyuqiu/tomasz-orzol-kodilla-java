package com.kodilla.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AvailableValues {
    private BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
    private SudokuBoard sudokuBoard = SudokuBoard.getInstance();
    private Set<String> usedValues = new HashSet<>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
    private SudokuElement sudokuElement;

    public void availableValuesForField() {
        int count = 0;
        for (int columnNumber = 0; columnNumber <= 8; columnNumber++) {
            for (int rowNumber = 0; rowNumber <= 8; rowNumber++) {
                count++;
                sudokuElement = sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber);
                System.out.println(sudokuElement);
                OnePartOfBoard onePartOfBoard = sudokuBoard.checkWhichPartOfBoard(columnNumber, rowNumber);
                for (int columnIteration = 0; columnIteration <= 8; columnIteration++) {
                    addPossibleNumber(columnIteration, rowNumber, sudokuElement);
                }
                for (int rowIteration = 0; rowIteration <= 8; rowIteration++) {
                    addPossibleNumber(columnNumber, rowIteration, sudokuElement);
                }
                if (onePartOfBoard.valuesFromOneOfNine().contains(sudokuElement.getValue())
                        && !(sudokuElement.getValue() == SudokuElement.EMPTY)) {
                    checkBoard();
                } else {
                    usedValues.removeAll(onePartOfBoard.valuesFromOneOfNine());
                }
                usedValues.remove(SudokuElement.EMPTY);
                sudokuElement.setPossilbeValues(usedValues);
                System.out.println("used values " + usedValues);
                System.out.println("count " +count);
                System.out.println(sudokuElement);
            }
        }
    }

    private void addPossibleNumber(int columnNumber, int rowNumber, SudokuElement sudokuElement) {
        if (usedValues.contains(sudokuElement.getValue()) && !(sudokuElement.getValue() == SudokuElement.EMPTY)) {
            checkBoard();
        } else {
            System.out.println("value from board " + sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber).getValue());
            usedValues.remove(sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber).getValue());

        }
    }

    private void checkBoard() {
        SudokuBoard oldSudokuBoard = retrievePreviousBoard();
        System.out.println(oldSudokuBoard);
        if (!oldSudokuBoard.equals(sudokuBoard)) {
            sudokuBoard = oldSudokuBoard;
        } else {
            removeUnsolvableSudoku();
        }
    }

    public SudokuBoard retrievePreviousBoard() {
        System.out.println(Messages.VALUEEXIST);
        sudokuBoard = backtrackCopies.getBacktrack().get(0);
        return sudokuBoard;
    }

    public void removeUnsolvableSudoku() {
        System.out.println(Messages.CANNOTSOLVE);
        backtrackCopies.getBacktrack().remove(0);
    }
}

