package com.kodilla.rps;

public class PlayersScoresDto {
    private int playerOneScore;
    private int playerTwoScore;

    public PlayersScoresDto(int playerOneScore, int playerTwoScore) {
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
