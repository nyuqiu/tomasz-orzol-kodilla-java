package com.kodilla.rps;

import java.util.Objects;

public class EveryRoundPlayersMovesDto {
    private Move playerOneMove;
    private Move playerTwoMove;

    public EveryRoundPlayersMovesDto(Move playerOneMove, Move playerTwoMove) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EveryRoundPlayersMovesDto that = (EveryRoundPlayersMovesDto) o;
        return playerOneMove == that.playerOneMove &&
                playerTwoMove == that.playerTwoMove;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerOneMove, playerTwoMove);
    }
}
