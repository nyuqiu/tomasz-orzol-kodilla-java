package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SudokuGame {
    private BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
    private AvailableValues availableValues = new AvailableValues();

    public boolean resolveSudoku(SudokuBoard sudokuBoard) {

//        System.out.println("save copy");
//        try {
//            backtrackCopies.getBacktrack().add(sudokuBoard.deepCopy());
//        } catch (Exception e) {
//
//        }
        while (sudokuBoard.getBoardValues().contains(SudokuElement.EMPTY)) {

            for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
                for (int rowNumber = 0; rowNumber < 9; rowNumber++) {

                    availableValues.availableValuesForField();
                    SudokuElement sudokuElement = sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber);
                    if (sudokuElement.getValue().contains(SudokuElement.EMPTY)) {
                        Set<String> setOfPossibleValues = sudokuElement.getPossibleValues();
                        List<String> listOfPossibleValues = new ArrayList<>(setOfPossibleValues);
                        System.out.println("possible elements of " + columnNumber + " " + rowNumber);
                        if (sudokuElement.getValue().contains(SudokuElement.EMPTY)) {
                            while (setOfPossibleValues.size() > 1) {

                                String setNumber = listOfPossibleValues.get(0);

                                System.out.println("possible elements of " + columnNumber + " " + rowNumber + " " + listOfPossibleValues);

                                setOfPossibleValues.remove(setNumber);
                                listOfPossibleValues.remove(setNumber);

                                System.out.println("possible elements list " + listOfPossibleValues);

                                System.out.println("possible elements set " + setOfPossibleValues);

                                System.out.println("setting value " + setNumber);
                                sudokuElement.setValue(setNumber);
                                System.out.println("save copy");
                                System.out.println(sudokuBoard);
                                try {
                                    backtrackCopies.getBacktrack().add(sudokuBoard.deepCopy());
                                } catch (CloneNotSupportedException e) {

                                }
                            } if (setOfPossibleValues.size() == 1) {
                                String setNumber = listOfPossibleValues.get(0);
                                setOfPossibleValues.remove(setNumber);
                                listOfPossibleValues.remove(setNumber);
                                System.out.println("setting value " + setNumber);
                                sudokuElement.setValue(setNumber);
                            } else if (setOfPossibleValues.size() == 0) {
                                System.out.println("from SudokuGame");
                                rowNumber--;
                                sudokuBoard = availableValues.checkBoard();
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

}

