package chess;

import boardgame.Position;

public class ChessPosition {
    private char column;
    private int row;

    public ChessPosition(char column, int row){
        if(column < 'a' || column > 'h' || row < 1 || row > 8){
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8.");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    /*Converte uma posição de xadrez (a1...h8) para uma posição de matriz ([0][0]...[7][7])*/
    protected Position toPosition(){
        return new Position(8 - this.row, this.column - 'a');
    }

    /*Converte uma posição de matriz ([0][0]...[7][7]) para uma posição de xadrez (a1...h8)*/
    protected static ChessPosition fromPosition(Position position){
        return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString(){
        return "" + this.column + this.row;
    }
}
