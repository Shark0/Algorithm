package com.shark.gametree;

public class MoveEvaluation {

    public final int score;

    public final IGameMove move;

    public MoveEvaluation() {
        this.move = null;
        this.score = minimum();
    }

    public MoveEvaluation(int score) {
        this.move = null;
        this.score = score;
    }

    public MoveEvaluation(IGameMove move, int score) {
        this.move = move;
        this.score = score;
    }

    public static final int minimum() {
        return Integer.MIN_VALUE + 1;
    }

    public static final int maximum() {
        return Integer.MAX_VALUE;
    }

    public String toString() {
        return move + " for " + score;
    }
}
