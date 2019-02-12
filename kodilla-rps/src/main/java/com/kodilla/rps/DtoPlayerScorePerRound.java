package com.kodilla.rps;

public class DtoPlayerScorePerRound {
    private int playerOneScore;
    private int playerTwoScore;

    public DtoPlayerScorePerRound(int playerOneScore, int playerTwoScore) {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }
}
