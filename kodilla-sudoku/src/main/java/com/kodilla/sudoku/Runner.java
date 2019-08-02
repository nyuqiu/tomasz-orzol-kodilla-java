package com.kodilla.sudoku;

public class Runner {


    public static void main(String[] args) {
        BacktrackCopies backtrackCopies = BacktrackCopies.getInstance();

        boolean gameFinished = false;
//        while (!gameFinished) {
        System.out.println("start test");
        SudokuBoard sudokuBoard = SudokuBoard.getInstance();
        System.out.println("                     populowanie boardu");
//        Random random = new Random();
//        for (int row = 0; row < 9; row++) {
//            for (int column = 0; column < 9; column++) {
//                sudokuBoard.setValue(column, row, String.valueOf(random.nextInt(9)+1));
//            }
//        }

//        int value = 9;
//        for (int row = 0; row < 9; row++) {
//            value += 4;
//            for (int column = 0; column < 9; column++) {
//                value++;
//                sudokuBoard.setValue(column, row, String.valueOf(value % 9 + 1));
//            }
//        }

        System.out.println(sudokuBoard);
        System.out.println("pierwszy krok");
        SudokuGame theGame = new SudokuGame();

        backtrackCopies.getBacktrack().add(sudokuBoard);

        System.out.println(sudokuBoard);

        sudokuBoard.setValue(0, 0, "1");
        sudokuBoard.setValue(1, 1, "2");

        System.out.println("oryginal " + sudokuBoard);

        System.out.println("getting right part of code");

        gameFinished = theGame.resolveSudoku(sudokuBoard);


        System.out.println("oryginal " + sudokuBoard);

        System.out.println("finish test");


    }
}
