package com.kodilla.rps;

import java.util.Random;

public class AvaliableMoves {
    private String stone = "stone";
    private String scissors = "scissors";
    private String paper = "paper";

    public Dao playStone(int percentForWin) {
        String playerMove = "stone";
        String computerMove = computerMove(playerMove, percentForWin);

        return mechanism(playerMove, computerMove);
    }

    private Dao mechanism(String playerMove, String computerMove) {
        int playerOneScore = 0;
        int playerTwoScore = 0;
        if(playerMove.equals(scissors) && computerMove.equals(paper)){
            playerOneScore = 1;
        } else if(playerMove.equals(stone) && computerMove.equals(scissors)){
            playerOneScore = 1;
        } else if(playerMove.equals(paper) && computerMove.equals(stone)){
            playerOneScore = 1;
        } else if(playerMove.equals(stone) && computerMove.equals(paper)){
            playerTwoScore = 1;
        } else if(playerMove.equals(paper) && computerMove.equals(scissors)){
            playerTwoScore = 1;
        } else if(playerMove.equals(scissors) && computerMove.equals(stone)){
            playerTwoScore = 1;
        }
        Dao dao = new Dao(playerOneScore, playerTwoScore);
        return dao;
    }

    private String computerMove(String playerMove, int percentForWin) {
        String toWin = null;
        String toDraw = null;
        String toLose = null;
        Random random = new Random();
        int chances = random.nextInt(100);
        switch (playerMove) {
            case "stone":
                toWin = scissors;
                toDraw = stone;
                toLose = paper;
                break;
            case "scissors":
                toWin = paper;
                toDraw = scissors;
                toLose = stone;
                break;
            case "paper":
                toWin = stone;
                toDraw = paper;
                toLose = scissors;
        }

        if (chances > percentForWin) {
            int drawOrLose = random.nextInt(2);
            if (drawOrLose == 1) {
                System.out.println("Second player played "+toLose);
                return toLose;
            } else {
                System.out.println("Second player played "+toDraw);
                return toDraw;
            }
        } else {
            System.out.println("Second player played "+toWin);
            return toWin;
        }
    }
}
