package com.kodilla.rps;

public class DaoPlayersMoves {
    private Move playerOneMove;
    private Move playerTwoMove;

    public DaoPlayersMoves(Move playerOneMove, Move playerTwoMove) {
        this.playerOneMove = playerOneMove;
        this.playerTwoMove = playerTwoMove;
    }

    public Move getPlayerOneMove() {
        return playerOneMove;
    }

    public Move getPlayerTwoMove() {
        return playerTwoMove;
    }


}
