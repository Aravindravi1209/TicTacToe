package Strategies.GameWinningStrategies;

import Models.Board;
import Models.Cell;
import Models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiagonalWinningStrategy implements GameWinningStrategy{
    private HashMap<Character, Integer> leftDiag = new HashMap<>();
    private HashMap<Character, Integer> rightDiag = new HashMap<>();
    @Override
    public boolean checkIfWon(Board board, Player player, Cell cell) {
        int row=cell.getRow();
        int col=cell.getColumn();
        System.out.println(row+" "+col);
        if(row==col)
        {
            leftDiag.put(cell.getSymbol().getCh(),leftDiag.getOrDefault(cell.getSymbol().getCh(),0)+1);
        }
        if((row+col)==board.getDimension()-1)
        {
            rightDiag.put(cell.getSymbol().getCh(),rightDiag.getOrDefault(cell.getSymbol().getCh(),0)+1);
        }
        if(leftDiag.containsKey(cell.getSymbol().getCh()))
        {
            if(leftDiag.get(cell.getSymbol().getCh())== board.getDimension()) return true;
        }
        if(rightDiag.containsKey(cell.getSymbol().getCh())) {
            if (rightDiag.get(cell.getSymbol().getCh()) == board.getDimension()) return true;
        }
        return false;
    }
}
