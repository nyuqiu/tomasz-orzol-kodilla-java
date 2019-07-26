package com.kodilla.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class AvailableValues {
    private BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
    SudokuBoard sudokuBoard = backtrackCopies.getBacktrack().get(0);
//    private SudokuBoard sudokuBoard = SudokuBoard.getInstance();
    private Set<String> usedValues;
    private SudokuElement sudokuElement;

    public void availableValuesForField() {
        System.out.println("Used values " + usedValues);
        int count = 0;
        for (int columnNumber = 0; columnNumber <= 8; columnNumber++) {
            for (int rowNumber = 0; rowNumber <= 8; rowNumber++) {
                usedValues = new HashSet<>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
                count++;
                sudokuElement = sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber);
                System.out.println("Value of checking element " + sudokuElement.getValue()+ " column " + columnNumber + " row " +rowNumber);
                for (int columnIteration = 0; columnIteration <= 8; columnIteration++) {
                    System.out.println("Get value from " + columnIteration + " " + rowNumber);
                    addPossibleNumber(columnIteration, rowNumber, sudokuElement);
                }
                for (int rowIteration = 0; rowIteration <= 8; rowIteration++) {
                    System.out.println("Get value from " + columnNumber + " " + rowIteration);
                    addPossibleNumber(columnNumber, rowIteration, sudokuElement);
                }
                if (sudokuBoard.getValuesFromOneOfNine(columnNumber, rowNumber).contains(sudokuElement.getValue())
                        && !(sudokuElement.getValue().equals(SudokuElement.EMPTY))) {
                    checkBoard();
                } else {
                    sudokuBoard.getValuesFromOneOfNine(columnNumber, rowNumber).forEach(n->usedValues.remove(n));
                }
                System.out.println("TRUE TEST " + sudokuBoard.getValuesFromOneOfNine(columnNumber, rowNumber));
                sudokuElement.setPossilbeValues(usedValues);
                System.out.println("Used values 2 " + usedValues);
                System.out.println("count " +count);
                System.out.println(sudokuElement);
            }
        }
    }

    private void addPossibleNumber(int columnNumber, int rowNumber, SudokuElement sudokuElement) {
        System.out.println("Used values 3 " + usedValues);
        if (usedValues.contains(sudokuElement.getValue()) && !(sudokuElement.getValue() == SudokuElement.EMPTY)) {
            checkBoard();
        } else {
            System.out.println("value from board " + sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber).getValue());
            usedValues.remove(sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber).getValue());

        }
        System.out.println("Used values 4 " + usedValues);
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
        System.out.println("Size of array of copies " + backtrackCopies.getBacktrack().size());
        System.out.println(Messages.VALUEEXIST);
        sudokuBoard = backtrackCopies.getBacktrack().get(0);
        return sudokuBoard;
    }

    public void removeUnsolvableSudoku() {
        System.out.println(Messages.CANNOTSOLVE);
        backtrackCopies.getBacktrack().remove(0);
    }
}

