package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public class GameMechanism {
    public Dao play(Move move, int percentForWin) {
        ComputerMechanism computerMechanism = new ComputerMechanism();
        Move computerMove = computerMechanism.computerMechanism(move, percentForWin);

        return mechanism(move, computerMove);
    }
    private Dao mechanism(Move playerMove, Move computerMove) {
        int playerOneScore = 0;
        int playerTwoScore = 0;
        boolean ifDraw = false;

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
                }
            } else {
                ifDraw = true;
            }
        }
        if(playerOneScore==0 && !ifDraw){
            playerTwoScore++;
        }

        Dao dao = new Dao(playerOneScore, playerTwoScore);
        return dao;
    }
}
