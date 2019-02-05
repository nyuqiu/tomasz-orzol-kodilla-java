package com.kodilla.rps;

import java.util.*;

class odlb {


    enum Move {
        ROCK, PAPER, SCISSORS
    }

    enum RoundResult {
        COMPUTER_WIN, HUMAN_WIN, TIE
    }

    static class GameRound {

        private Move computerMove;
        private Move humanMove;

        public GameRound(Move computerMove, Move humanMove) {
            this.computerMove = computerMove;
            this.humanMove = humanMove;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GameRound gameRound = (GameRound) o;
            return computerMove == gameRound.computerMove &&
                    humanMove == gameRound.humanMove;
        }

        @Override
        public int hashCode() {
            return Objects.hash(computerMove, humanMove);
        }
    }

    public static void main(String[] args) {

        final Map<GameRound, RoundResult> gameLogicMap = new HashMap<>();

        gameLogicMap.put(new GameRound(Move.PAPER, Move.PAPER), RoundResult.TIE);
        gameLogicMap.put(new GameRound(Move.SCISSORS, Move.SCISSORS), RoundResult.TIE);
        gameLogicMap.put(new GameRound(Move.ROCK, Move.ROCK), RoundResult.TIE);

        gameLogicMap.put(new GameRound(Move.ROCK, Move.SCISSORS), RoundResult.COMPUTER_WIN);
        gameLogicMap.put(new GameRound(Move.ROCK, Move.PAPER), RoundResult.HUMAN_WIN);

        gameLogicMap.put(new GameRound(Move.PAPER, Move.ROCK), RoundResult.COMPUTER_WIN);
        gameLogicMap.put(new GameRound(Move.PAPER, Move.SCISSORS), RoundResult.HUMAN_WIN);

        gameLogicMap.put(new GameRound(Move.SCISSORS, Move.PAPER), RoundResult.COMPUTER_WIN);
        gameLogicMap.put(new GameRound(Move.SCISSORS, Move.ROCK), RoundResult.HUMAN_WIN);


        int computerScore = 0;
        int humanScore = 0;

        final Scanner scanner = new Scanner(System.in);
        final Move computerMove = randomMove();
        final Move humanMove = getMoveFromHuman(scanner);

        System.out.println("Computer: " + computerMove);
        System.out.println("Human: " + humanMove);

        final RoundResult roundResult = gameLogicMap.get(new GameRound(computerMove, humanMove));

        switch (roundResult) {
            case COMPUTER_WIN:
                computerScore++;
                break;
            case HUMAN_WIN:
                humanScore++;
                break;
        }

        System.out.println("Result: " + roundResult);

    }

    private static Move getMoveFromHuman(Scanner scanner) {
        String result;

        final List<String> validMoves = Arrays.asList("1", "2", "3");

        do {
            System.out.println("Chose your move: ");
            System.out.println("[1] ROCK");
            System.out.println("[2] PAPER");
            System.out.println("[3] SCISSORS");
            result = scanner.next();
        } while (!validMoves.contains(result));

        return Move.values()[Integer.parseInt(result) - 1];
    }

    private static Move randomMove() {
        final Random random = new Random();
        final Move[] values = Move.values();
        final int i = random.nextInt(3);  // 0,1,2
        return values[i];
    }


}

