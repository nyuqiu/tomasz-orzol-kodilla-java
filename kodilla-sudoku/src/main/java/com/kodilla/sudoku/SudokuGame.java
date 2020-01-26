package com.kodilla.sudoku;

import java.util.List;

public class SudokuGame {
    private BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
    private AvailableValues availableValues = new AvailableValues();
    private SudokuBoard sudokuBoard = backtrackCopies.getBacktrack().get(0);

    public int resolveSudoku() {
        int resolvedSudokusCount = 0;
        do
        {
            while (sudokuBoard.getBoardValues().contains(SudokuElement.EMPTY)) {
                System.out.println(sudokuBoard.getBoardValues());
                for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
                    for (int rowNumber = 0; rowNumber < 9; rowNumber++) {
                        availableValues.availableValuesForField();
                        SudokuElement sudokuElement = sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber);
                        if (sudokuElement.getValue().contains(SudokuElement.EMPTY)) {
                            List<String> possibleValues = sudokuElement.getPossibleValues();
                            while (possibleValues.size() > 1) {
                                for (int i = 0; i < possibleValues.size() - 1; ) {
                                    String setNumber = possibleValues.get(0);
                                    possibleValues.remove(setNumber);
                                    sudokuElement.setValue(setNumber);
                                    try {
                                        backtrackCopies.getBacktrack().add(sudokuBoard.deepCopy());
                                    } catch (CloneNotSupportedException e) {

                                    }
                                }
                            }
                            if (possibleValues.size() == 1) {
                                String setNumber = possibleValues.get(0);
                                possibleValues.remove(setNumber);
                                sudokuElement.setValue(setNumber);
                            } else if (possibleValues.size() == 0) {
                                try {
                                    sudokuBoard = availableValues.retrievePreviousBoard();
                                } catch (NullPointerException e) {
                                    return resolvedSudokusCount;
                                }

                            }
                        }
                    }
                }
            }
            try {
                sudokuBoard = availableValues.retrievePreviousBoard();
            } catch (NullPointerException e) {
                return resolvedSudokusCount;
            }
            System.out.println(resolvedSudokusCount);
            resolvedSudokusCount++;
        }
        while (backtrackCopies.getBacktrack().size() > 0);
        return resolvedSudokusCount;
    }
}




