package com.shark.gametree;

import java.util.Collection;

public interface IPlayer {
    public int eval(IGameState gameState);
    public void score(IGameScore gameScore);
    public Collection<IGameMove> validMoves(IGameState gameState);
}
