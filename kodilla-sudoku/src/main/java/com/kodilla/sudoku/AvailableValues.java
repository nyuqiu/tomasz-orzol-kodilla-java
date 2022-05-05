package com.kodilla.sudoku;

import java.util.*;
import java.util.stream.Collectors;

public class AvailableValues {
    private SudokuBoard sudokuBoard = SudokuBoard.getInstance();
    private List<String> possibleValues;

    public boolean isEnoughAvaliableValuesForField() {
        for (int columnNumber = 0; columnNumber <= 8; columnNumber++) {
            for (int rowNumber = 0; rowNumber <= 8; rowNumber++) {

                SudokuElement sudokuElement = sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber);

                if (sudokuElement.getValue().contains(SudokuElement.EMPTY)) {

                    sudokuElement.setPossibleValues(new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9")));

                    possibleValues = sudokuElement.getPossibleValues();

                    for (int columnIteration = 0; columnIteration <= 8; columnIteration++) {
                        addPossibleNumber(columnIteration, rowNumber, sudokuElement);
                        if (isMoreEmptyFieldsThanValuesAvailable(sudokuBoard.getColumnElements(columnNumber)))
                            return false;
                    }
                    for (int rowIteration = 0; rowIteration <= 8; rowIteration++) {
                        addPossibleNumber(columnNumber, rowIteration, sudokuElement);
                        if (isMoreEmptyFieldsThanValuesAvailable(sudokuBoard.getRowElements(columnNumber)))
                            return false;
                    }
                    if ((sudokuBoard.getValuesFromOneOfNine(columnNumber, rowNumber).contains(sudokuElement.getValue())
                            && !(sudokuElement.getValue().equals(SudokuElement.EMPTY)))
                    || isMoreEmptyFieldsThanValuesAvailable(sudokuBoard.getElementsFromOneOfNine(columnNumber, rowNumber))) {
                        return false;
                    } else {
                        sudokuBoard.getValuesFromOneOfNine(columnNumber, rowNumber).forEach(n -> possibleValues.remove(n));
                        possibleValues.remove(sudokuElement.getValue());
                    }
                    sudokuElement.setPossibleValues(possibleValues);
                }
            }
        }
        return true;
    }

    private void addPossibleNumber(int columnNumber, int rowNumber, SudokuElement sudokuElement) {
        possibleValues = sudokuElement.getPossibleValues();

        if (possibleValues.contains(sudokuElement.getValue()) && !(sudokuElement.getValue().equals(SudokuElement.EMPTY))) {
            possibleValues = new ArrayList<>();
        } else {
            possibleValues.remove(sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber).getValue());
            possibleValues.remove(sudokuElement.getValue());
        }
    }

    private int getHigestNumberOfPossibleValues(Set<SudokuElement> input) {
        return input.stream()
                .map(SudokuElement::getPossibleValues)
                .collect(Collectors.toList())
                .stream()
                .map(List::size)
                .collect(Collectors.summarizingInt(Integer::intValue)).getMax();
    }

    private int countEmptySpaces(Set<SudokuElement> input) {
        return (int) input.stream()
                .map(n -> Objects.equals(n.getValue(), SudokuElement.EMPTY))
                .count();
    }

    private boolean isMoreEmptyFieldsThanValuesAvailable(Set<SudokuElement> input) {
        return getHigestNumberOfPossibleValues(input) <= countEmptySpaces(input);


    }
}