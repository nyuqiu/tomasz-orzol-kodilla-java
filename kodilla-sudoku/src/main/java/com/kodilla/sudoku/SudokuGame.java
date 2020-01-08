package com.kodilla.sudoku;

import java.util.List;

public class SudokuGame {
    private BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();
    private AvailableValues availableValues = new AvailableValues();

    public boolean resolveSudoku(SudokuBoard sudokuBoard) {

        while (sudokuBoard.getBoardValues().contains(SudokuElement.EMPTY)) {

            for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
                for (int rowNumber = 0; rowNumber < 9; rowNumber++) {

                    availableValues.availableValuesForField();
                    System.out.println("checking values");

                    SudokuElement sudokuElement = sudokuBoard.fieldByColumnAndRow(columnNumber, rowNumber);
                    if (sudokuElement.getValue().contains(SudokuElement.EMPTY)) {
                        List<String> possibleValues = sudokuElement.getPossibleValues();

                        System.out.println("possible elements of " + columnNumber + " " + rowNumber + " " + possibleValues);
                        if (sudokuElement.getValue().contains(SudokuElement.EMPTY)) {
                            while (possibleValues.size() > 1) {

                                for (int i = 0; i < possibleValues.size() - 1; ) {
                                    String setNumber = possibleValues.get(i);

                                    System.out.println("possible elements set " + possibleValues);

                                    System.out.println("setting value " + setNumber);
                                    sudokuElement.setValue(setNumber);  //VERY IMPORTANT, put that fcking back as sudokuElement viable
                                    System.out.println("save copy");
                                    System.out.println(sudokuBoard);
                                    try {
                                        backtrackCopies.getBacktrack().add(sudokuBoard.deepCopy());
                                    } catch (CloneNotSupportedException e) {

                                    }
//                                    possibleValues.removeAll(toRemove);
                                }

                            }
                            if (possibleValues.size() == 1) {
                                String setNumber = possibleValues.get(0);
                                possibleValues.remove(setNumber);
                                System.out.println("setting value " + setNumber);  // co sie tu dzieje, usuwa dostepne liczby po kolei i nie sprawdza pozniej od nowa i nie ma co wstawic
                                sudokuElement.setValue(setNumber);


                            } else if (possibleValues.size() == 0) {
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

