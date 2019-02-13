package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public final class ListWithCombinations {
    private static ListWithCombinations listWithCombinationsInstatnce = null;
    private List<DtoPlayersMoves> movesInFavorPlayerOne;

    private ListWithCombinations() {
        this.movesInFavorPlayerOne = new ArrayList<>();
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
    }

    public static ListWithCombinations getInstance(){
        if(listWithCombinationsInstatnce == null){
            listWithCombinationsInstatnce = new ListWithCombinations();
        }
        return listWithCombinationsInstatnce;
    }

    public List<DtoPlayersMoves> getMovesInFavorPlayerOne() {
        return movesInFavorPlayerOne;
    }


}
