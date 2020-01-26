package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AvailableValues {
    private BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
    private SudokuBoard sudokuBoard = SudokuBoard.getInstance();
    private List<String> possibleValues;
    private SudokuElement sudokuElement;

    public void availableValuesForField() {
        for (int columnNumber = 0; columnNumber <= 8; columnNumber++) {
            for (int rowNumber = 0; rowNumber <= 8; rowNumber++) {

                sudokuElement = sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber);

                if (sudokuElement.getValue().contains(SudokuElement.EMPTY)) {

                    sudokuElement.setPossibleValues(new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9")));

                    possibleValues = sudokuElement.getPossibleValues();

                    for (int columnIteration = 0; columnIteration <= 8; columnIteration++) {
                        addPossibleNumber(columnIteration, rowNumber, sudokuElement);
                    }
                    for (int rowIteration = 0; rowIteration <= 8; rowIteration++) {
                        addPossibleNumber(columnNumber, rowIteration, sudokuElement);
                    }
                    if (sudokuBoard.getValuesFromOneOfNine(columnNumber, rowNumber).contains(sudokuElement.getValue())
                            && !(sudokuElement.getValue().equals(SudokuElement.EMPTY))) {
                        sudokuBoard = retrievePreviousBoard();
                        System.out.println(sudokuBoard);
                    } else {
                        sudokuBoard.getValuesFromOneOfNine(columnNumber, rowNumber).forEach(n -> possibleValues.remove(n));
                        possibleValues.remove(sudokuElement.getValue());
                    }
                    sudokuElement.setPossibleValues(possibleValues);
                }
            }
        }
    }

    private void addPossibleNumber(int columnNumber, int rowNumber, SudokuElement sudokuElement) {
        possibleValues = sudokuElement.getPossibleValues();

        if (possibleValues.contains(sudokuElement.getValue()) && !(sudokuElement.getValue().equals(SudokuElement.EMPTY))) {
            retrievePreviousBoard();
        } else {
            possibleValues.remove(sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber).getValue());
            possibleValues.remove(sudokuElement.getValue());
        }
    }

    SudokuBoard retrievePreviousBoard() {
        System.out.println(Messages.VALUEEXIST);
        if (backtrackCopies.getBacktrack().size() > 0) {
            sudokuBoard = backtrackCopies.getBacktrack().get(backtrackCopies.getBacktrack().size()-1);
            backtrackCopies.getBacktrack().remove(sudokuBoard);
            availableValuesForField();
            return sudokuBoard;
        } else {
            System.out.println("No more saved boards");
            return null;
        }
    }
}

