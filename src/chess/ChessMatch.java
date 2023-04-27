package chess;

import boardgame.Board;
import boardgame.Piece;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch(){
        this.board = new Board(8, 8);
        this.initialSetup();
    }

    //Retorna uma matriz de peças de xadrez a partir da matriz de peças do tabuleiro.
    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[this.board.getRows()][this.board.getColumns()];

        for(int i = 0; i < board.getRows(); i++){
            for(int j = 0; j < board.getColumns(); j++){
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }

        return mat;
    }

    /*Posiciona uma nova peça a partir de uma posição de xadrez (a1...h8)*/
    private void placeNewPiece(char column, int row, Piece piece){
        this.board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    //Inicia a partida de xadrez, colocando as peças no tabuleiro.
    private void initialSetup(){
        this.placeNewPiece('b', 6, new Rook(this.board, Color.WHITE));
        this.placeNewPiece('e', 8, new King(this.board, Color.BLACK));
        this.placeNewPiece('e', 1, new King(this.board, Color.WHITE));
    }
}
