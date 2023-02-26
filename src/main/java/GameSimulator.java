import Controllers.GameController;
import Models.*;
import Strategies.GameWinningStrategies.DiagonalWinningStrategy;
import Strategies.GameWinningStrategies.GameWinningStrategy;
import Strategies.GameWinningStrategies.RowColWinningStrategy;

import java.util.List;

public class GameSimulator {
    public static void main(String[] args) {
        int dimension=4;
        Player p1 = new HumanPlayer(new Symbol('X'));
        Player p2 = new Bot(new Symbol('O'), BotDifficultyLevel.EASY);
        GameWinningStrategy strategy1 = new RowColWinningStrategy();
        GameWinningStrategy strategy2 = new DiagonalWinningStrategy();
        GameController gameController = new GameController();

        Game game = gameController.createGame(dimension, List.of(p1,p2),List.of(strategy1,strategy2));

        while(gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS))
        {
            System.out.println("Please make the next move. This is the current State: ");
            gameController.display(game);
            gameController.makeMove(game);
        }

        if (gameController.getGameStatus(game).equals(GameStatus.ENDED)) {
            System.out.println("WINNER WINNER CHICKEN DINNER");
            gameController.display(game);
        }

        if (gameController.getGameStatus(game).equals(GameStatus.DRAW)) {
            System.out.println("UH OH. Try Again. No one won");
            gameController.display(game);
        }

    }
}
