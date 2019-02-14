package com.kodilla.rps;

import java.util.List;
import java.util.stream.Collectors;

public class RoundResult {

    public PlayersScoresDto play(Move move, int percentForWin) {
        ComputerMechanism computerMechanism = new ComputerMechanism();
        Move computerMove = computerMechanism.computerMechanism(move, percentForWin);
        System.out.println("Computer played "+computerMove);

        return roundResult(move, computerMove);
    }
    private PlayersScoresDto roundResult(Move playerMove, Move computerMove) {
        ListWithCombinations listWithCombinations = ListWithCombinations.getInstance();
        int playerOneScore = 0;
        int playerTwoScore = 0;

        List<EveryRoundPlayersMovesDto> compareList = listWithCombinations.getMovesInFavorPlayerOne();
        compareList =  compareList.stream()
                .filter(n -> n.equals(new EveryRoundPlayersMovesDto(playerMove, computerMove)))
                .collect(Collectors.toList());

        if(playerMove != computerMove){
            if(compareList.size() == 1){
                playerOneScore = 1;
            } else {
                playerTwoScore = 1;
            }
        }
        return new PlayersScoresDto(playerOneScore, playerTwoScore);
    }
}
