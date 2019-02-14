package com.kodilla.rps;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ComputerMechanism {
    private Map<Move, ComputersAnswersForPlayersMove> computersAnswers() {
        Map<Move, ComputersAnswersForPlayersMove> mapOfComputersAnswers = new HashMap<>();
        mapOfComputersAnswers.put(Move.ROCK, new ComputersAnswersForPlayersMove(Move.SCISSORS, Move.LIZARD, Move.ROCK, Move.PAPER, Move.SPOCK));
        mapOfComputersAnswers.put(Move.SCISSORS, new ComputersAnswersForPlayersMove(Move.LIZARD, Move.PAPER, Move.SCISSORS, Move.ROCK, Move.SPOCK));
        mapOfComputersAnswers.put(Move.PAPER, new ComputersAnswersForPlayersMove(Move.SCISSORS, Move.LIZARD, Move.PAPER, Move.SPOCK, Move.ROCK));
        mapOfComputersAnswers.put(Move.SPOCK, new ComputersAnswersForPlayersMove(Move.LIZARD, Move.PAPER, Move.SPOCK, Move.ROCK, Move.SCISSORS));
        mapOfComputersAnswers.put(Move.LIZARD, new ComputersAnswersForPlayersMove(Move.SCISSORS, Move.ROCK, Move.LIZARD, Move.PAPER, Move.SPOCK));
        return mapOfComputersAnswers;
    }

    protected Move computerMechanism(Move playerMove, int percentForWin) {
        Random random = new Random();
        Move toWin = computersAnswers().get(playerMove).getToWin();
        Move toWin1 = computersAnswers().get(playerMove).getToWin1();
        Move toDraw = computersAnswers().get(playerMove).getToDraw();
        Move toLose = computersAnswers().get(playerMove).getToLose();
        Move toLose1 = computersAnswers().get(playerMove).getToLose1();

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
