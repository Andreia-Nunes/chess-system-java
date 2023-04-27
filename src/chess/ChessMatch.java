package chess;

import boardgame.Board;
import boardgame.Position;
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

    //Inicia a partida de xadrez, colocando as peças no tabuleiro.
    private void initialSetup(){
        this.board.placePiece(new Rook(this.board, Color.WHITE), new Position(2, 1));
        this.board.placePiece(new King(this.board, Color.BLACK), new Position(0,  4));
        this.board.placePiece(new King(this.board, Color.WHITE), new Position(7, 4));
    }
}
