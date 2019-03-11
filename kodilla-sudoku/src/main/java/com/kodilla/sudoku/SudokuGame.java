package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SudokuGame {

    public boolean resolveSudoku() {
        AvaiableValues avaiableValues = new AvaiableValues();
        SudokuBoard sudokuBoard = SudokuBoard.getInstance();


        for (int columnNumber = 0; columnNumber < 9; columnNumber++) {
            for (int rowNumber = 0; rowNumber < 9; rowNumber++) {
                SudokuElement sudokuElement = sudokuBoard.getSudokuColumns().get(columnNumber).getSudokuRow().get(rowNumber);
                if(sudokuElement.getValue()==-1){
                    if(sudokuElement.getPossilbeValues().size()==1){
                        List<Integer> onePossibleElement = new ArrayList<>(sudokuElement.getPossilbeValues());
                        sudokuElement.setValue(onePossibleElement.get(0));
                    }
                }
            }
        }
    }
}

