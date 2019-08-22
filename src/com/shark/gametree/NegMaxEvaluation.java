package com.shark.gametree;

import java.util.*;

public class NegMaxEvaluation implements IEvaluation {

    IGameState state;
    int ply;

    public NegMaxEvaluation(int ply) {
        this.ply = ply;
    }

    public IGameMove bestMove(IGameState s, IPlayer player, IPlayer opponent) {
        state = s.copy();
        MoveEvaluation me = negmax(ply, player, opponent);
        return me.move;
    }

    public MoveEvaluation negmax(int ply, IPlayer player, IPlayer opponent) {
        Iterator<IGameMove> it = player.validMoves(state).iterator();
        if (ply == 0 || !it.hasNext()) {
            return new MoveEvaluation(player.eval(state));
        }
        MoveEvaluation best = new MoveEvaluation(MoveEvaluation.minimum());
        while (it.hasNext()) {
            IGameMove move = it.next();
            move.execute(state);
            MoveEvaluation me = negmax(ply - 1, opponent, player);
            move.undo(state);
            if (-me.score > best.score) {
                best = new MoveEvaluation(move, -me.score);
            }
        }
        return best;
    }

    public String toString() {
        return state.toString();
    }
}
