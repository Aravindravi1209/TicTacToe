package Strategies.GameWinningStrategies;

import Models.Board;
import Models.Cell;
import Models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RowColWinningStrategy implements GameWinningStrategy{
    private List<HashMap<Character, Integer>> rowCharCounts;
    private List<HashMap<Character, Integer>> colCharCounts;
    private void initializeCounts(Board board) {
        rowCharCounts = new ArrayList<>();
        colCharCounts = new ArrayList<>();

        for (int i = 0; i < board.getDimension(); ++i) {
            rowCharCounts.add(new HashMap<>());
            colCharCounts.add(new HashMap<>());
        }
    }
    @Override
    public boolean checkIfWon(Board board, Player player, Cell cell) {
        if(rowCharCounts==null)
        {
            initializeCounts(board);
        }
        int row = cell.getRow();
        int col = cell.getColumn();
        rowCharCounts.get(row).put(cell.getSymbol().getCh(),rowCharCounts.get(row).getOrDefault(cell.getSymbol().getCh(),0)+1);
        colCharCounts.get(col).put(cell.getSymbol().getCh(),colCharCounts.get(col).getOrDefault(cell.getSymbol().getCh(),0)+1);

        if(rowCharCounts.get(row).get(cell.getSymbol().getCh()).equals(board.getDimension())) return true;
        if(colCharCounts.get(col).get(cell.getSymbol().getCh()).equals(board.getDimension())) return true;
        return false;

    }
}
