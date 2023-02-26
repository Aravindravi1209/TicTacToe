package Controllers;

import Exceptions.EmptyMovesUndoOperationException;
import Models.*;
import Strategies.GameWinningStrategies.GameWinningStrategy;

import java.util.List;

public class GameController {
    public Game createGame(int dimensionsOfBoard, List<Player> players, List<GameWinningStrategy> strategies)
    {
        Game game=null;
        try
        {
            game=Game.create().
                    setDimension(dimensionsOfBoard)
                    .addPlayers(players)
                    .addGameWinningStrategies(strategies)
                    .build();
        } catch (Exception exception) {
            System.out.println("We did something wrong");
            exception.printStackTrace();
        }
        return game;
    }
    public void makeMove(Game game)
    {
        game.makeMove();
    }
    public void undo(Game game) throws EmptyMovesUndoOperationException {
        game.undo();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public GameStatus getGameStatus(Game game) {
        return game.getGameStatus();
    }

    public void display(Game game) {
        game.getBoard().printBoard();
    }

}
