package com.kodilla.rps;

import java.util.List;
import java.util.Random;

public class ComputerMechanism {
    MapOfComputersAnswers computersAnswers = MapOfComputersAnswers.getInstance();

    protected Move computerMechanism(Move playerMove, int percentForWin) {
        Random random = new Random();
        List<Move> toWin = computersAnswers.getMapOfComputersAnswers().get(playerMove).getToWin();
        List<Move> toDraw = computersAnswers.getMapOfComputersAnswers().get(playerMove).getToDraw();
        List<Move> toLose = computersAnswers.getMapOfComputersAnswers().get(playerMove).getToLose();


        int chances = random.nextInt(100) + 1;
        int drawOrLose = random.nextInt(3);

        if (chances > percentForWin && drawOrLose == 0) {
            return toLose.get(drawOrLose);
        } else if (chances > percentForWin && drawOrLose == 1) {
            return toLose.get(drawOrLose);
        } else if (chances > percentForWin && drawOrLose == 2) {
            return toDraw.get(0);
        } else {
            return toWin.get(random.nextInt(2));
        }
    }
}
