package com.kodilla.rps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class MapOfComputersAnswers {
    private static MapOfComputersAnswers mapOfComputersAnswersInstance = null;
    private Map<Move, ComputersAnswersForPlayersMove> mapOfComputersAnswers;

    private MapOfComputersAnswers() {
        this.mapOfComputersAnswers = new HashMap<>();
        mapOfComputersAnswers.put(Move.ROCK, new ComputersAnswersForPlayersMove(
                new ArrayList<>(Arrays.asList(Move.SCISSORS, Move.LIZARD)),
                new ArrayList<>(Arrays.asList(Move.ROCK)),
                new ArrayList<>(Arrays.asList(Move.PAPER, Move.SPOCK))));
        mapOfComputersAnswers.put(Move.SCISSORS, new ComputersAnswersForPlayersMove(
        new ArrayList<>(Arrays.asList(Move.LIZARD, Move.PAPER)),
                new ArrayList<>(Arrays.asList(Move.SCISSORS)),
                new ArrayList<>(Arrays.asList(Move.ROCK, Move.SPOCK))));
        mapOfComputersAnswers.put(Move.PAPER, new ComputersAnswersForPlayersMove(
        new ArrayList<>(Arrays.asList(Move.SCISSORS, Move.LIZARD)),
                new ArrayList<>(Arrays.asList(Move.PAPER)),
                new ArrayList<>(Arrays.asList(Move.SPOCK, Move.ROCK))));
        mapOfComputersAnswers.put(Move.SPOCK, new ComputersAnswersForPlayersMove(
        new ArrayList<>(Arrays.asList(Move.LIZARD, Move.PAPER)),
                new ArrayList<>(Arrays.asList(Move.SPOCK)),
                new ArrayList<>(Arrays.asList(Move.ROCK, Move.SCISSORS))));
        mapOfComputersAnswers.put(Move.LIZARD, new ComputersAnswersForPlayersMove(
        new ArrayList<>(Arrays.asList(Move.SCISSORS, Move.ROCK)),
                new ArrayList<>(Arrays.asList(Move.LIZARD)),
                new ArrayList<>(Arrays.asList(Move.PAPER, Move.SPOCK))));{
        }
    }

    public static MapOfComputersAnswers getInstance(){
        if(mapOfComputersAnswersInstance ==null){
            mapOfComputersAnswersInstance = new MapOfComputersAnswers();
        }
        return mapOfComputersAnswersInstance;
    }

    public Map<Move, ComputersAnswersForPlayersMove> getMapOfComputersAnswers() {
        return mapOfComputersAnswers;
    }
}
