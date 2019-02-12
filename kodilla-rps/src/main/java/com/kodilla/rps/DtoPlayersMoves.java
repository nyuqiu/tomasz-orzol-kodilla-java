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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DtoPlayersMoves that = (DtoPlayersMoves) o;
        return playerOneMove == that.playerOneMove &&
                playerTwoMove == that.playerTwoMove;
    }
}
