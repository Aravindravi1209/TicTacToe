package Strategies.BotPlayingStrategies;

import Models.Board;
import Models.Move;
import Models.Player;

public interface BotPlayingStrategy {
    Move makeNextMove(Board board, Player player);
}
