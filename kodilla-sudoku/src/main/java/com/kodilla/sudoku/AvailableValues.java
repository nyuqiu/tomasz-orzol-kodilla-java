package com.kodilla.sudoku;

import java.util.Set;

public class AvailableValues {
    private BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
    //    SudokuBoard sudokuBoard = backtrackCopies.getBacktrack().get(0);
    private SudokuBoard sudokuBoard = SudokuBoard.getInstance();
    private Set<String> possibleValues;
    private SudokuElement sudokuElement;

    public void availableValuesForField() {
        for (int columnNumber = 0; columnNumber <= 8; columnNumber++) {
            for (int rowNumber = 0; rowNumber <= 8; rowNumber++) {
                sudokuElement = sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber);
                if (sudokuElement.getValue().contains(SudokuElement.EMPTY)) {

                    possibleValues = sudokuElement.getPossibleValues();


                    for (int columnIteration = 0; columnIteration <= 8; columnIteration++) {
                        addPossibleNumber(columnIteration, rowNumber, sudokuElement);
                    }
                    for (int rowIteration = 0; rowIteration <= 8; rowIteration++) {
                        addPossibleNumber(columnNumber, rowIteration, sudokuElement);
                    }
                    if (sudokuBoard.getValuesFromOneOfNine(columnNumber, rowNumber).contains(sudokuElement.getValue())
                            && !(sudokuElement.getValue().equals(SudokuElement.EMPTY))) {
                        checkBoard();
                        System.out.println(sudokuBoard);
                    } else {
                        sudokuBoard.getValuesFromOneOfNine(columnNumber, rowNumber).forEach(n -> possibleValues.remove(n));
                    }
                }
            }
        }
    }

    private void addPossibleNumber(int columnNumber, int rowNumber, SudokuElement sudokuElement) {
        possibleValues = sudokuElement.getPossibleValues();

        if (possibleValues.contains(sudokuElement.getValue()) && !(sudokuElement.getValue().equals(SudokuElement.EMPTY))) {
            checkBoard();
        } else {
            possibleValues.remove(sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber).getValue());

        }

    }

    private void checkBoard() {
        SudokuBoard savedSudokuBoard = retrievePreviousBoard();
        System.out.println(savedSudokuBoard);
        if (!savedSudokuBoard.equals(sudokuBoard)) {
            sudokuBoard = savedSudokuBoard;
        } else {
            removeUnsolvableSudoku();
        }
    }

    public SudokuBoard retrievePreviousBoard() {
        System.out.println("retrieved board");
        System.out.println(Messages.VALUEEXIST);
        if (backtrackCopies.getBacktrack().size() > 0) {
            sudokuBoard = backtrackCopies.getBacktrack().get(0);
            return sudokuBoard;
        }
        System.out.println("No more saved boards");
        return null;
    }

    public void removeUnsolvableSudoku() {
//        System.out.println(backtrackCopies.getBacktrack());
        System.out.println(Messages.CANNOTSOLVE);
        System.out.println(backtrackCopies.getBacktrack().size());
        backtrackCopies.getBacktrack().remove(0);
    }
}

