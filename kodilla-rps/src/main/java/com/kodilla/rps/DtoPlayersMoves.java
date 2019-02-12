package com.kodilla.rps;

public class DtoPlayersMoves {
    private Move playerOneMove;
    private Move playerTwoMove;

    public DtoPlayersMoves(Move playerOneMove, Move playerTwoMove) {
        this.playerOneMove = playerOneMove;
        this.playerTwoMove = playerTwoMove;
    }

    public Move getPlayerOneMove() {
        return playerOneMove;
    }

    public Move getPlayerTwoMove() {
        return playerTwoMove;
    }

    public void setPlayerOneMove(Move playerOneMove) {
        this.playerOneMove = playerOneMove;
    }

    public void setPlayerTwoMove(Move playerTwoMove) {
        this.playerTwoMove = playerTwoMove;
    }
}
