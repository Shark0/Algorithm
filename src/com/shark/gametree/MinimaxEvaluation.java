package com.shark.gametree;

import java.util.Iterator;

public class MinimaxEvaluation implements IEvaluation {

    IGameState state;
    int ply;
    IPlayer original;
    public int numStates = 0;

    public MinimaxEvaluation(int ply) {
        this.ply = ply;
    }

    @Override
    public IGameMove bestMove(IGameState gameState, IPlayer player, IPlayer opponent) {
        this.original = player;
        this.state = gameState.copy();
        this.numStates ++;
        MoveEvaluation moveEvaluation = minimax(ply ,IComparator.MAX, player, opponent);
        return moveEvaluation.move;
    }

    MoveEvaluation minimax(int ply, IComparator comparator, IPlayer player, IPlayer opponent) {
        Iterator<IGameMove> gameMoves = player.validMoves(state).iterator();
        if(ply == 0 || !gameMoves.hasNext()) {
            return  new MoveEvaluation(original.eval(state));
        }
        MoveEvaluation best = new MoveEvaluation(comparator.initialValue());
        while (gameMoves.hasNext()) {
            IGameMove move = gameMoves.next();
            move.execute(state);
            MoveEvaluation moveEvaluation = minimax(ply -1, comparator.opposite(), opponent, player);
            if(comparator.compare(best.score, moveEvaluation.score) < 0) {
                best = new MoveEvaluation(move, moveEvaluation.score);
            }
        }
        return best;
    }
}
