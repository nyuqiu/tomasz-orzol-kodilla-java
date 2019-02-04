package com.kodilla.rps;

public class Dao {
    private int playerOneScore;
    private int playerTwoScore;

    public Dao(int playerOneScore, int playerTwoScore) {
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
