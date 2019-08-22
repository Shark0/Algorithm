package com.shark.gametree;

public interface IEvaluation {
    public IGameMove bestMove(IGameState gameState, IPlayer player, IPlayer opponent);
}
