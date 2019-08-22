package com.shark.gametree;

public interface IGameMove {
    boolean isValid(IGameState gameState);
    boolean execute(IGameState gameState);
    boolean undo(IGameState gameState);
}
