package com.kodilla.rps;

public class NewGameDto {
    private int playerOneWonRounds;
    private int playerTwoWonRounds;
    private int howManyRoundsToWin;
    private int howManyPercentToWin;

    public NewGameDto(int playerOneWonRounds, int playerTwoWonRounds, int howManyRoundsToWin, int howManyPercentToWin) {
        this.playerOneWonRounds = playerOneWonRounds;
        this.playerTwoWonRounds = playerTwoWonRounds;
        this.howManyRoundsToWin = howManyRoundsToWin;
        if (howManyPercentToWin < 0 || 100 < howManyPercentToWin) {
            System.out.println("Avaliable range is 0 to 100. Try again");
        } else {
            this.howManyPercentToWin = howManyPercentToWin;
        }
    }

    public int getPlayerOneWonRounds() {
        return playerOneWonRounds;
    }

    public int getPlayerTwoWonRounds() {
        return playerTwoWonRounds;
    }

    public int getHowManyRoundsToWin() {
        return howManyRoundsToWin;
    }

    public int getHowManyPercentToWin() {
        return howManyPercentToWin;
    }
}
