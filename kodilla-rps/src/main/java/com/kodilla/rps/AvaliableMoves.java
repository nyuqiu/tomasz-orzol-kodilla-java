package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AvaliableMoves {


    public Dao play(Move move, int percentForWin) {
        Move computerMove = computerMove(move, percentForWin);
        System.out.println("Player one move is " + move);
        System.out.println("Computer move is " + computerMove);

        return mechanism(move, computerMove);
    }


    private Dao mechanism(Move playerMove, Move computerMove) {
        int playerOneScore = 0;
        int playerTwoScore = 0;

        List<DaoPlayersMoves> movesInFavorPlayerOne = new ArrayList<>();
        movesInFavorPlayerOne.add(new DaoPlayersMoves(Move.SCISSORS, Move.PAPER));
        movesInFavorPlayerOne.add(new DaoPlayersMoves(Move.SCISSORS, Move.LIZARD));
        movesInFavorPlayerOne.add(new DaoPlayersMoves(Move.ROCK, Move.SCISSORS));
        movesInFavorPlayerOne.add(new DaoPlayersMoves(Move.ROCK, Move.LIZARD));
        movesInFavorPlayerOne.add(new DaoPlayersMoves(Move.PAPER, Move.ROCK));
        movesInFavorPlayerOne.add(new DaoPlayersMoves(Move.PAPER, Move.SPOCK));
        movesInFavorPlayerOne.add(new DaoPlayersMoves(Move.SPOCK, Move.SCISSORS));
        movesInFavorPlayerOne.add(new DaoPlayersMoves(Move.SPOCK, Move.ROCK));
        movesInFavorPlayerOne.add(new DaoPlayersMoves(Move.LIZARD, Move.PAPER));
        movesInFavorPlayerOne.add(new DaoPlayersMoves(Move.LIZARD, Move.SPOCK));

        for (DaoPlayersMoves daoPlayersMoves : movesInFavorPlayerOne) {
            if (!(playerMove == computerMove)) {
                if (new DaoPlayersMoves(playerMove, computerMove).equals(daoPlayersMoves)) {
                    playerOneScore++;
                } else {
                    playerTwoScore++;
                }
            }
        }
        Dao dao = new Dao(playerOneScore, playerTwoScore);
        return dao;
    }

    private Move computerMove(Move playerMove, int percentForWin) {
        Move toWin = null;
        Move toWin1 = null;
        Move toDraw = null;
        Move toLose = null;
        Move toLose1 = null;

        switch (playerMove) {
            case ROCK:
                toWin = Move.SCISSORS;
                toWin1 = Move.LIZARD;
                toDraw = Move.ROCK;
                toLose = Move.PAPER;
                toLose1 = Move.SPOCK;
                break;
            case SCISSORS:
                toWin = Move.LIZARD;
                toWin1 = Move.PAPER;
                toDraw = Move.SCISSORS;
                toLose = Move.ROCK;
                toLose1 = Move.SPOCK;
                break;
            case PAPER:
                toWin = Move.SCISSORS;
                toWin1 = Move.LIZARD;
                toDraw = Move.PAPER;
                toLose = Move.SPOCK;
                toLose1 = Move.ROCK;
            case SPOCK:
                toWin = Move.LIZARD;
                toWin1 = Move.PAPER;
                toDraw = Move.SPOCK;
                toLose = Move.ROCK;
                toLose1 = Move.SCISSORS;
            case LIZARD:
                toWin = Move.SCISSORS;
                toWin1 = Move.ROCK;
                toDraw = Move.LIZARD;
                toLose = Move.PAPER;
                toLose1 = Move.SPOCK;
        }

        Random random = new Random();
        int chances = random.nextInt(100);

        if (chances > percentForWin) {
            int drawOrLose = random.nextInt(3);
            if (drawOrLose == 1) {
                return toLose;
            } else if (drawOrLose == 2) {
                return toLose1;
            } else if (drawOrLose == 3) {
                return toDraw;
            }
        } else {
            if (random.nextInt(2) == 1) {
                return toWin;
            } else if (random.nextInt(2) == 2) {
                return toWin1;
            }
        }

//        if (chances > percentForWin) {
//            int drawOrLose = random.nextInt(2);
//            if (drawOrLose == 1) {
//                System.out.println("Second player played "+toLose);
//                return toLose;
//            } else {
//                System.out.println("Second player played "+toDraw);
//                return toDraw;
//            }
//        } else {
//            System.out.println("Second player played "+toWin);
//            return toWin;
//        }
    }
}
