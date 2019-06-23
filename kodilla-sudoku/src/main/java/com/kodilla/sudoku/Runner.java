package com.kodilla.sudoku;

public class Runner {


    public static void main(String[] args) {
        BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();

        boolean gameFinished = false;
//        while (!gameFinished) {
        System.out.println("start test");
        SudokuGame theGame = new SudokuGame();
        SudokuBoard sudokuBoard = SudokuBoard.getInstance();


        sudokuBoard.setValue(0, 0, "1");
        sudokuBoard.setValue(0, 1, "2");
        sudokuBoard.setValue(0, 2, "3");
        sudokuBoard.setValue(0, 3, "4");
        sudokuBoard.setValue(0, 4, "5");
        sudokuBoard.setValue(0, 5, "6");
        sudokuBoard.setValue(0, 6, "7");
        sudokuBoard.setValue(0, 7, "8");
        sudokuBoard.setValue(0, 8, "9");

        System.out.println(sudokuBoard.fieldByColumnAndRow(0,0));
        sudokuBoard.populateColumnsAndRowsValues();
        System.out.println(sudokuBoard.getColumnsValues().get(0));
        sudokuBoard.setValue(0,0,"2");
        System.out.println(sudokuBoard.getColumnsValues().get(0));
        sudokuBoard.populateColumnsAndRowsValues();
        System.out.println(sudokuBoard.getColumnsValues().get(0));

//            gameFinished = theGame.resolveSudoku(sudokuBoard);

        System.out.println("finish test");

//        }

        // przetestuj czy value z elementa sie zmienia w hashmapie czy tylko pobiera do nowego obiektu przy kazdym uruchomieniu metody
    }
}
