package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;

public class AvailableValues {
    private BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
    private SudokuBoard sudokuBoard = SudokuBoard.getInstance();
    private Set<Integer> usedValues = new HashSet<>();
    private SudokuElement sudokuElement = new SudokuElement();



    public void availableValuesForField(SudokuBoard sudokuBoard) {
        int count = 0;
        for (int columnNumber = 0; columnNumber <= 8; columnNumber++) {
            for (int rowNumber = 0; rowNumber <= 8; rowNumber++) {
                count++;
                sudokuElement = sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber);
                OnePartOfBoard onePartOfBoard = sudokuBoard.checkWhichPartOfBoard(columnNumber, rowNumber);
                if (sudokuElement.getValue() == SudokuElement.EMPTY) {
                    for (int columnIteration = 0; columnIteration <= 8; columnIteration++) {
                        addPossibleNumber(columnIteration, rowNumber);
                    }
                    for (int rowIteration = 0; rowIteration <= 8; rowIteration++) {
                        addPossibleNumber(columnNumber, rowIteration);
                    }
                    if (onePartOfBoard.valuesFromOneOfNine().contains(sudokuElement.getValue())
                            && !(sudokuElement.getValue() == SudokuElement.EMPTY)) {
                        checkBoard();
                    } else {
                        usedValues.addAll(onePartOfBoard.valuesFromOneOfNine());
                    }
                    usedValues.remove(SudokuElement.EMPTY);
                    sudokuElement.setPossilbeValues(usedValues);
                    System.out.println(usedValues);
                    System.out.println(count);
                    System.out.println(onePartOfBoard);
                    System.out.println(sudokuElement);
                }
            }
        }
    }

    private void addPossibleNumber(int columnNumber, int rowNumber) {
        if (usedValues.contains(sudokuElement.getValue()) && !(sudokuElement.getValue() == SudokuElement.EMPTY)) {
            checkBoard();
        } else {
            usedValues.add(sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber).getValue());
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

