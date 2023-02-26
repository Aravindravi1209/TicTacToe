package Strategies.GameWinningStrategies;

import Models.Board;
import Models.Cell;
import Models.Player;

public interface GameWinningStrategy {
    boolean checkIfWon(Board board, Player player, Cell cell);
}
