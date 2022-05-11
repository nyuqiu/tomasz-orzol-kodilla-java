package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class SudokuGame {
    final List<SudokuBoard> finishedBoards = new ArrayList<>();
    private final BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
    private final AvailableValues availableValues = new AvailableValues();
    private SudokuBoard sudokuBoard = SudokuBoard.getInstance();
    private List<String> possibleValues;
    private SudokuElement sudokuElement;

    public int resolveSudoku() {
        while (sudokuBoard.getBoardValues().contains(SudokuElement.EMPTY)) {
            for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
                for (int rowNumber = 0; rowNumber < 9; rowNumber++) {
                    sudokuElement = sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber);
                    if (sudokuBoard != null && Objects.equals(sudokuElement.getValue(), SudokuElement.EMPTY)) {
                        if (availableValues.isEnoughPossibleValues(columnNumber, rowNumber)) {
                            possibleValues = sudokuElement.getPossibleValues();
                            while (possibleValues.size() > 1) {
                                for (int i = 0; i < possibleValues.size() - 1; ) {
                                    setValue();
                                    try {
                                        backtrackCopies.getBacktrack().add(sudokuBoard.deepCopy());
                                        System.out.println("number of copies: " + backtrackCopies.getBacktrack().size());
                                    } catch (CloneNotSupportedException e) {

                                    }
                                }
                            }
                            if (possibleValues.size() == 1) {
                                setValue();
                                if (!sudokuBoard.getBoardValues().contains(SudokuElement.EMPTY)) {
                                    finishedBoards.add(sudokuBoard);
                                    System.out.println(sudokuBoard);
                                    retrievePreviousBoard();
                                }
                            } else {
                                retrievePreviousBoard();
                            }
                        } else {
                            retrievePreviousBoard();
                        }
                    }
                }
            }
        }
        System.out.println(finishedBoards);
        return finishedBoards.size();
    }

    private void retrievePreviousBoard() {
        if (backtrackCopies.getBacktrack().size() > 0) {
            IntStream.range(0, 8)
                    .forEach(n -> sudokuBoard.getSudokuColumns().set(n, backtrackCopies.getBacktrack().get(0).getSudokuColumns().get(n)));
            sudokuBoard.repopulateValuesInOneOfNine();
            backtrackCopies.getBacktrack().remove(0);
        }
    }

    private void setValue() {
        String setNumber = possibleValues.get(0);
        possibleValues.remove(setNumber);
        sudokuElement.setValue(setNumber);
    }
}