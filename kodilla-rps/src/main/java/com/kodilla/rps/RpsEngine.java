package com.kodilla.rps;    

public class RpsEngine {
    private boolean rock;
    private boolean paper;
    private boolean scissors;

    public RpsEngine(boolean rock, boolean paper, boolean scissors) {
        this.rock = rock;
        this.paper = paper;
        this.scissors = scissors;
    }

    public boolean isRock() {
        return rock;
    }

    public boolean isPaper() {
        return paper;
    }

    public boolean isScissors() {
        return scissors;
    }


}
