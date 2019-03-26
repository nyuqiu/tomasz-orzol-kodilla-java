package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public final class ListWithCombinations {
    private static ListWithCombinations listWithCombinationsInstatnce = null;
    private List<EveryRoundPlayersMovesDto> movesInFavorPlayerOne;

    private ListWithCombinations() {
        this.movesInFavorPlayerOne = new ArrayList<>();
        movesInFavorPlayerOne.add(new EveryRoundPlayersMovesDto(Move.SCISSORS, Move.PAPER));
        movesInFavorPlayerOne.add(new EveryRoundPlayersMovesDto(Move.SCISSORS, Move.LIZARD));
        movesInFavorPlayerOne.add(new EveryRoundPlayersMovesDto(Move.ROCK, Move.SCISSORS));
        movesInFavorPlayerOne.add(new EveryRoundPlayersMovesDto(Move.ROCK, Move.LIZARD));
        movesInFavorPlayerOne.add(new EveryRoundPlayersMovesDto(Move.PAPER, Move.ROCK));
        movesInFavorPlayerOne.add(new EveryRoundPlayersMovesDto(Move.PAPER, Move.SPOCK));
        movesInFavorPlayerOne.add(new EveryRoundPlayersMovesDto(Move.SPOCK, Move.SCISSORS));
        movesInFavorPlayerOne.add(new EveryRoundPlayersMovesDto(Move.SPOCK, Move.ROCK));
        movesInFavorPlayerOne.add(new EveryRoundPlayersMovesDto(Move.LIZARD, Move.PAPER));
        movesInFavorPlayerOne.add(new EveryRoundPlayersMovesDto(Move.LIZARD, Move.SPOCK));
    }

    public static ListWithCombinations getInstance(){
        if(listWithCombinationsInstatnce == null){
            listWithCombinationsInstatnce = new ListWithCombinations();
        }
        return listWithCombinationsInstatnce;
    }

    public List<EveryRoundPlayersMovesDto> getMovesInFavorPlayerOne() {
        return movesInFavorPlayerOne;
    }


}
