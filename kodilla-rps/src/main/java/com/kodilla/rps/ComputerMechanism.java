package com.kodilla.rps;

import java.util.Random;

public class ComputerMechanism {

    protected Move computerMechanism(Move playerMove, int percentForWin) {
        Random random = new Random();
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

        int chances = random.nextInt(100) + 1;
        int drawOrLose = random.nextInt(3);

        if (chances > percentForWin && drawOrLose == 2) {
            return toLose;
        } else if (chances > percentForWin && drawOrLose == 1) {
            return toLose1;
        } else if (chances > percentForWin && drawOrLose == 0) {
            return toDraw;
        } else if (chances < percentForWin && (drawOrLose == 0 || drawOrLose == 1)) {
            return toWin;
        } else {
            return toWin1;
        }
    }
}
