package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuGame {
    final List<SudokuBoard> finishedBoards = new ArrayList<>();
    private final BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
    private final AvailableValues availableValues = new AvailableValues();
    private SudokuBoard sudokuBoard = backtrackCopies.getBacktrack().get(0);
    private List<String> possibleValues;
    private SudokuElement sudokuElement;

    public int resolveSudoku() {
        while (sudokuBoard.getBoardValues().contains(SudokuElement.EMPTY)) {
            for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
                for (int rowNumber = 0; rowNumber < 9; rowNumber++) {
                    if (sudokuBoard != null) {
                        availableValues.availableValuesForField();
                        sudokuElement = sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber);
                        if (sudokuElement.getValue().equals(SudokuElement.EMPTY)) {
                            possibleValues = sudokuElement.getPossibleValues();
                            while (possibleValues.size() > 1) {
                                for (int i = 0; i < possibleValues.size() - 1; ) {
                                    setValue();
                                    try {
                                        backtrackCopies.getBacktrack().add(sudokuBoard.deepCopy());
                                    } catch (CloneNotSupportedException e) {

                                    }
                                }
                            }
                            if (possibleValues.size() == 1) {
                                setValue();
                                if(!sudokuBoard.getBoardValues().contains(SudokuElement.EMPTY)){
                                    finishedBoards.add(sudokuBoard);
                                }
                            } else if (possibleValues.size() == 0) {
                                try {
                                    sudokuBoard = retrievePreviousBoard();
                                } catch (NullPointerException e) {

                                }
                            }
                        }
                    } else {
                        return finishedBoards.size();
                    }
                }
            }
        }
        System.out.println(finishedBoards);
        return finishedBoards.size();
    }

    private SudokuBoard retrievePreviousBoard() {
        if (backtrackCopies.getBacktrack().size() > 0 && backtrackCopies.getBacktrack().remove(sudokuBoard)) {
            sudokuBoard = backtrackCopies.getBacktrack().get(0);
            availableValues.availableValuesForField();
            return sudokuBoard;
        } else {
            System.out.println("No more saved boards");
            return null;
        }
    }

    private void setValue() {
        String setNumber = possibleValues.get(0);
        possibleValues.remove(setNumber);
        sudokuElement.setValue(setNumber);
    }
}