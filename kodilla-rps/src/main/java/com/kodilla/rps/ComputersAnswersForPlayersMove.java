package com.kodilla.rps;

public class ComputersAnswersForPlayersMove {
    private Move toWin;
    private Move toWin1;
    private Move toDraw;
    private Move toLose;
    private Move toLose1;

    public ComputersAnswersForPlayersMove(Move toWin, Move toWin1, Move toDraw, Move toLose, Move toLose1) {
        this.toWin = toWin;
        this.toWin1 = toWin1;
        this.toDraw = toDraw;
        this.toLose = toLose;
        this.toLose1 = toLose1;
    }

    public Move getToWin() {
        return toWin;
    }

    public Move getToWin1() {
        return toWin1;
    }

    public Move getToDraw() {
        return toDraw;
    }

    public Move getToLose() {
        return toLose;
    }

    public Move getToLose1() {
        return toLose1;
    }
}
