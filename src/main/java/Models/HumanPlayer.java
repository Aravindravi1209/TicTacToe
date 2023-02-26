package Models;

import java.util.Scanner;

public class HumanPlayer extends Player{
    public HumanPlayer(Symbol symbol)
    {
        super(symbol,PlayerType.HUMAN);
    }
    @Override
    public Move makeMove(Board board) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the row number starting from 1: ");
        int row = myObj.nextInt()-1;
        System.out.println("Enter the column number starting from 1: ");
        int col = myObj.nextInt()-1;

        Move move = new Move();
        Cell cell = new Cell();
        cell.setRow(row);
        cell.setColumn(col);
        cell.setSymbol(this.getSymbol());
        move.setPlayer(this);
        move.setCell(cell);
        move.setSymbol(this.getSymbol());
        return move;
    }
}
