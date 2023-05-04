package chess;

import boardgame.Board;
import boardgame.Piece;
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

    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        this.validateSourcePosition(position);
        return this.board.piece(position).possibleMoves();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        this.validateSourcePosition(source);
        this.validateTargetPosition(source, target);
        Piece capturedPiece = this.makeMove(source, target);
        return (ChessPiece) capturedPiece;
    }

    private Piece makeMove(Position source, Position target){
        Piece p = this.board.removePiece(source);
        Piece capturedPiece = this.board.removePiece(target);
        this.board.placePiece(p, target);
        return capturedPiece;
    }

    private void validateSourcePosition(Position position){
        if(!this.board.thereIsAPiece(position)){
            throw new ChessException("There is no piece on source position");
        }
        if(!this.board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("There is no possible moves for the choice piece");
        }
    }

    private void validateTargetPosition(Position source, Position target){
        if(!this.board.piece(source).possibleMove(target)){
            throw new ChessException("The chosen piece can't move to target position");
        }
    }

    /*Posiciona uma nova peça a partir de uma posição de xadrez (a1...h8)*/
    private void placeNewPiece(char column, int row, Piece piece){
        this.board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    //Inicia a partida de xadrez, colocando as peças no tabuleiro.
    private void initialSetup(){
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
    }
}
