package com.shark.gametree;

public interface IGameState {
    public boolean isDraw();
    public boolean isWin();
    public IGameState copy();
    public boolean equivalent(IGameState gameState);
}
