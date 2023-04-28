package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows < 1 && columns < 1){
            throw new BoardException("Error creating boar: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    /*Retorna uma peça dada uma linha e uma coluna*/
    public Piece piece(int row, int column){
        if(!this.positionExists(row, column)){
            throw new BoardException("Position not on the board");
        }
        return this.pieces[row][column];
    }

    /*Retorna uma peça dada uma posição*/
    public Piece piece(Position position){
        if(!this.positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return this.pieces[position.getRow()][position.getColumn()];
    }

    /*Coloca uma peça em uma posição na matriz de peças do tabuleiro.
    Também insere um objeto Position na peça, o qual indica sua posição.*/
    public void placePiece(Piece piece, Position position){
        if(this.thereIsAPiece(position)){
            throw new BoardException("There is already a piece on position " + position);
        }
        this.pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    /*Remove uma peça do tabuleiro*/
    public Piece removePiece(Position position){
        if(!this.positionExists(position)){
            throw new BoardException("Position not on the board");
        }

        if(this.piece(position) == null){
            return null;
        }

        Piece aux = this.piece(position);
        aux.position = null;
        this.pieces[position.getRow()][position.getColumn()] = null;
        return aux;
    }


    /*Testa se uma posição existe no tabuleiro dada uma linha e uma coluna*/
    private boolean positionExists(int row, int column){
        return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
    }

    /*Testa se uma posição existe no tabuleiro dado um objeto Position*/
    public boolean positionExists(Position position){
        return this.positionExists(position.getRow(), position.getColumn());
    }

    /*Testa se existe uma peça em uma dada posição*/
    public boolean thereIsAPiece(Position position){
        if(!this.positionExists(position)){
            throw new BoardException("Position not on the board");
        }
        return this.piece(position) != null;
    }
}
