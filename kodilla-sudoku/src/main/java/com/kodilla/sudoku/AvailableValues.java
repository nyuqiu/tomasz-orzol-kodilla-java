package com.kodilla.sudoku;

import java.util.*;

public class AvailableValues {
    private Board board = Board.getInstance();
    private List<String> possibleValues;

    public void avaliableValuesForField(int columnNumber, int rowNumber) {
        Element element = board.fieldByColumnAndRow(columnNumber, rowNumber);

        if (element.getValue().contains(Element.EMPTY)) {

            element.setPossibleValues(new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9")));

            possibleValues = element.getPossibleValues();

            for (int columnIteration = 0; columnIteration <= 8; columnIteration++) {
                addPossibleNumber(columnIteration, rowNumber, element);
            }
            for (int rowIteration = 0; rowIteration <= 8; rowIteration++) {
                addPossibleNumber(columnNumber, rowIteration, element);
            }
            if (board.getValuesFromOneOfNine(columnNumber, rowNumber).contains(element.getValue())
                    && !(element.getValue().equals(Element.EMPTY))) {
                possibleValues = new ArrayList<>();
            } else {
                board.getValuesFromOneOfNine(columnNumber, rowNumber)
                        .forEach(n -> possibleValues.remove(n));
                possibleValues.remove(element.getValue());
            }
            element.setPossibleValues(possibleValues);
        }

    }


    private void addPossibleNumber(int columnNumber, int rowNumber, Element element) {
        possibleValues = element.getPossibleValues();

        if (possibleValues.contains(element.getValue()) && !(element.getValue().equals(Element.EMPTY))) {
            possibleValues = new ArrayList<>();
        } else {
            possibleValues.remove(board.fieldByColumnAndRow(columnNumber, rowNumber).getValue());
            possibleValues.remove(element.getValue());
        }
    }
}