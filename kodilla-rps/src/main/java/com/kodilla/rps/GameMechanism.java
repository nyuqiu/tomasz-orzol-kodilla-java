package com.kodilla.rps;

public class GameMechanism {

    public DtoPlayerScorePerRound play(Move move, int percentForWin) {
        ComputerMechanism computerMechanism = new ComputerMechanism();
        Move computerMove = computerMechanism.computerMechanism(move, percentForWin);
        System.out.println("Computer played "+computerMove);

        return mechanism(move, computerMove);
    }
    private DtoPlayerScorePerRound mechanism(Move playerMove, Move computerMove) {
        ListWithCombinations listWithCombinations = ListWithCombinations.getInstance();
        int playerOneScore = 0;
        int playerTwoScore = 0;
        boolean ifDraw = false;


        for (DtoPlayersMoves dtoPlayersMoves : listWithCombinations.getMovesInFavorPlayerOne()) {
            if (playerMove != computerMove) {
                if (new DtoPlayersMoves(playerMove, computerMove).equals(dtoPlayersMoves)) {  //to bardziej czytelne
                    playerOneScore++;
                }
            } else {
                ifDraw = true;
            }
        }
        if(playerOneScore==0 && !ifDraw){
            playerTwoScore++;
        }
        return new DtoPlayerScorePerRound(playerOneScore, playerTwoScore);
    }
}
