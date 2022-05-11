package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class SudokuGame {
    final List<Board> finishedBoards = new ArrayList<>();
    private final BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
    private final AvailableValues availableValues = new AvailableValues();
    private Board board = Board.getInstance();
    private List<String> possibleValues;
    private Element element;

    public int resolveSudoku() {
        while (board.getBoardValues().contains(Element.EMPTY)) {
            for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
                for (int rowNumber = 0; rowNumber < 9; rowNumber++) {
                    element = board.fieldByColumnAndRow(columnNumber, rowNumber);
                    if (board != null && Objects.equals(element.getValue(), Element.EMPTY)) {
                        if (availableValues.isEnoughPossibleValues(columnNumber, rowNumber)) {
                            possibleValues = element.getPossibleValues();
                            while (possibleValues.size() > 1) {
                                for (int i = 0; i < possibleValues.size() - 1; ) {
                                    setValue();
                                    try {
                                        backtrackCopies.getBacktrack().add(board.deepCopy());
                                        System.out.println("number of copies: " + backtrackCopies.getBacktrack().size());
                                    } catch (CloneNotSupportedException e) {

                                    }
                                }
                            }
                            if (possibleValues.size() == 1) {
                                setValue();
                                if (!board.getBoardValues().contains(Element.EMPTY)) {
                                    finishedBoards.add(board);
                                    System.out.println(board);
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
                    .forEach(n -> board.getColumns().set(n, backtrackCopies.getBacktrack().get(0).getColumns().get(n)));
            board.repopulateValuesInOneOfNine();
            backtrackCopies.getBacktrack().remove(0);
        }
    }

    private void setValue() {
        String setNumber = possibleValues.get(0);
        possibleValues.remove(setNumber);
        element.setValue(setNumber);
    }
}