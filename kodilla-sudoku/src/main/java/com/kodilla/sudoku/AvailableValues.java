package com.kodilla.sudoku;

import java.util.*;
import java.util.stream.Collectors;

public class AvailableValues {
    private Board board = Board.getInstance();
    private List<String> possibleValues;

    private void avaliableValuesForField() {
        for (int columnNumber = 0; columnNumber <= 8; columnNumber++) {
            for (int rowNumber = 0; rowNumber <= 8; rowNumber++) {
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
                        // to fix
                        board.getValuesFromOneOfNine(columnNumber, rowNumber)
                                .forEach(n -> possibleValues.remove(n));
                        possibleValues.remove(element.getValue());
                    }
                    element.setPossibleValues(possibleValues);
                }
            }
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

    private int getHigestNumberOfPossibleValues(Set<Element> input) {
        return input.stream()
                .map(n -> n.getPossibleValues().size())
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.summarizingInt(Integer::intValue)).getMax();
    }

    private int countEmptySpaces(Set<Element> input) {
        return (int) input.stream()
                .filter(n -> Objects.equals(n.getValue(), Element.EMPTY))
                .count();
    }

    private boolean isMoreValuesAvailableThanEmptyFields(Set<Element> input) {
        return getHigestNumberOfPossibleValues(input) >= countEmptySpaces(input);
    }

    public boolean isEnoughPossibleValues(int columnNumber, int rowNumber) {
        avaliableValuesForField();
        return isMoreValuesAvailableThanEmptyFields(board.getColumnElements(columnNumber)) ||
                isMoreValuesAvailableThanEmptyFields(board.getRowElements(rowNumber)) ||
                isMoreValuesAvailableThanEmptyFields(board.getElementsFromOneOfNine(columnNumber, rowNumber));
    }
}