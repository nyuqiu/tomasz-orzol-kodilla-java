package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public class GameMechanism {
    private List<DtoPlayersMoves> listWithCombinations() {
        List<DtoPlayersMoves> movesInFavorPlayerOne = new ArrayList<>();
        movesInFavorPlayerOne.add(new DtoPlayersMoves(Move.SCISSORS, Move.PAPER));
        movesInFavorPlayerOne.add(new DtoPlayersMoves(Move.SCISSORS, Move.LIZARD));
        movesInFavorPlayerOne.add(new DtoPlayersMoves(Move.ROCK, Move.SCISSORS));
        movesInFavorPlayerOne.add(new DtoPlayersMoves(Move.ROCK, Move.LIZARD));
        movesInFavorPlayerOne.add(new DtoPlayersMoves(Move.PAPER, Move.ROCK));
        movesInFavorPlayerOne.add(new DtoPlayersMoves(Move.PAPER, Move.SPOCK));
        movesInFavorPlayerOne.add(new DtoPlayersMoves(Move.SPOCK, Move.SCISSORS));
        movesInFavorPlayerOne.add(new DtoPlayersMoves(Move.SPOCK, Move.ROCK));
        movesInFavorPlayerOne.add(new DtoPlayersMoves(Move.LIZARD, Move.PAPER));
        movesInFavorPlayerOne.add(new DtoPlayersMoves(Move.LIZARD, Move.SPOCK));
        return movesInFavorPlayerOne;
    }

    public DtoPlayerScorePerRound play(Move move, int percentForWin) {
        ComputerMechanism computerMechanism = new ComputerMechanism();
        Move computerMove = computerMechanism.computerMechanism(move, percentForWin);
        System.out.println("Computer played "+computerMove);

        return mechanism(move, computerMove);
    }
    private DtoPlayerScorePerRound mechanism(Move playerMove, Move computerMove) {
        int playerOneScore = 0;
        int playerTwoScore = 0;
        boolean ifDraw = false;


        for (DtoPlayersMoves dtoPlayersMoves : listWithCombinations()) {
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
