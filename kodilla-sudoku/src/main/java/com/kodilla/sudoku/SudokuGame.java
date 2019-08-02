package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SudokuGame {
    private BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
    private AvailableValues availableValues = new AvailableValues();

    public boolean resolveSudoku(SudokuBoard sudokuBoard) {

        System.out.println("save copy");
        try {
            backtrackCopies.getBacktrack().add(sudokuBoard.deepCopy());
        } catch (Exception e) {

        }
        while (sudokuBoard.getBoardValues().contains(SudokuElement.EMPTY)) {

            for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
                for (int rowNumber = 0; rowNumber < 9; rowNumber++) {

                    availableValues.availableValuesForField();
                    SudokuElement sudokuElement = sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber);
                    if (sudokuElement.getValue().contains(SudokuElement.EMPTY)) {
                        Set<String> setOfPossibleValues = sudokuElement.getPossibleValues();
                        List<String> listOfPossibleValues = new ArrayList<>(setOfPossibleValues);
                        if (sudokuElement.getValue().contains(SudokuElement.EMPTY)) {
                            if (setOfPossibleValues.size() == 1) {
                                sudokuElement.setValue(listOfPossibleValues.get(0));
                            } else if (setOfPossibleValues.size() == 0) {
                                availableValues.removeUnsolvableSudoku();
                            }
                            while (setOfPossibleValues.size() > 1) {
                                System.out.println("save copy");
                                try {
                                    backtrackCopies.getBacktrack().add(sudokuBoard.deepCopy());
                                } catch (CloneNotSupportedException e) {

                                }



                                String setNumber = listOfPossibleValues.get(0);

                                System.out.println("possible elements of " + columnNumber + " " + rowNumber + " " + listOfPossibleValues);

                                setOfPossibleValues.remove(setNumber);
                                listOfPossibleValues.remove(setNumber);

                                System.out.println("possible elements list " + listOfPossibleValues);

                                System.out.println("possible elements set " + setOfPossibleValues);

                                System.out.println("setting value " + setNumber);
                                sudokuElement.setValue(setNumber);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

}

