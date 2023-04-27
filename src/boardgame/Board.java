package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Piece piece(int row, int column){
        return this.pieces[row][column];
    }

    public Piece piece(Position position){
        return this.pieces[position.getRow()][position.getColumn()];
    }

    /*Coloca uma peça em uma posição na matriz de peças do tabuleiro.
    Também insere um objeto Position na peça, o qual indica sua posição.*/
    public void placePiece(Piece piece, Position position){
        this.pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
}
