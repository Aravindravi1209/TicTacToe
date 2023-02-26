package Strategies.BotPlayingStrategies;

import Models.Board;
import Models.Cell;
import Models.Move;
import Models.Player;

import java.util.List;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move makeNextMove(Board board, Player player) {
        for(int i=0;i< board.getDimension();i++)
        {
            for(int j=0;j< board.getDimension();j++)
            {
                Cell cell = board.getBoard().get(i).get(j);
                if(cell.isEmpty())
                {
                    Move move = new Move();
                    cell.setRow(i);
                    cell.setColumn(j);
                    cell.setSymbol(player.getSymbol());
                    move.setSymbol(player.getSymbol());
                    move.setPlayer(player);
                    move.setCell(cell);
                    return move;
                }
            }
        }
        return null;
    }
}
