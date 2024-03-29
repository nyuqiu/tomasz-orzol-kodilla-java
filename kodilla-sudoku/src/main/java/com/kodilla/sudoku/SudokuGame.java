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

    public int resolveSudoku(boolean oneSolutionOnly) {
        while (board.getBoardValues().contains(Element.EMPTY)) {
            for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
                for (int rowNumber = 0; rowNumber < 9; rowNumber++) {
                    element = board.fieldByColumnAndRow(columnNumber, rowNumber);
                    if (board != null && Objects.equals(element.getValue(), Element.EMPTY)) {
                        availableValues.avaliableValuesForField(columnNumber, rowNumber);
                        possibleValues = element.getPossibleValues();
                        while (possibleValues.size() > 1) {
                            for (int i = 0; i < possibleValues.size() - 1; ) {
                                setValue();
                                addCopyToList(backtrackCopies.getBacktrack());
                            }
                        }
                        if (possibleValues.size() == 1) {
                            setValue();
                            if (!board.getBoardValues().contains(Element.EMPTY)) {
                                addCopyToList(finishedBoards);
                                if (oneSolutionOnly) return finishedBoards.size();
                                else retrievePreviousBoard();
                            }
                        } else {
                            if (!retrievePreviousBoard()) return finishedBoards.size();
                        }
                    }
                }
            }
        }
        return finishedBoards.size();
    }

    private boolean retrievePreviousBoard() {
        if (backtrackCopies.getBacktrack().size() > 0) {
            IntStream.range(0, 9)
                    .forEach(n -> board.getColumns().set(n, backtrackCopies.getBacktrack().get(0).getColumns().get(n)));
            board.repopulateValuesInOneOfNine();
            backtrackCopies.getBacktrack().remove(0);
            return true;
        } else {
            return false;
        }
    }

    private void setValue() {
        String setNumber = possibleValues.get(0);
        possibleValues.remove(setNumber);
        element.setValue(setNumber);
    }

    private void addCopyToList(List<Board> list) {
        try {
            list.add(board.deepCopy());
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
    }
}