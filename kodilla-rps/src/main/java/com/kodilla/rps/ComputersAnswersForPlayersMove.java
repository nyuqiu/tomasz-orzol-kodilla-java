package com.kodilla.rps;

import java.util.List;

public class ComputersAnswersForPlayersMove {
    private List<Move> toWin;
    private List<Move> toDraw;
    private List<Move> toLose;

    public ComputersAnswersForPlayersMove(List<Move> toWin, List<Move> toDraw, List<Move> toLose) {
        this.toWin = toWin;
        this.toDraw = toDraw;
        this.toLose = toLose;
    }

    public List<Move> getToWin() {
        return toWin;
    }

    public List<Move> getToDraw() {
        return toDraw;
    }

    public List<Move> getToLose() {
        return toLose;
    }
}
