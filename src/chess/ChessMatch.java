package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.*;

public class ChessMatch {
    private final Board board;
    private Integer turn;
    private Color currentPlayer;
    private Boolean check;
    private Boolean checkMate;
    private ChessPiece enPassantVulnerable;
    private ChessPiece promoted;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Color currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public Boolean getCheckMate() {
        return checkMate;
    }

    public void setCheckMate(Boolean checkMate) {
        this.checkMate = checkMate;
    }

    public ChessPiece getEnPassantVulnerable() {
        return enPassantVulnerable;
    }

    public void setEnPassantVulnerable(ChessPiece enPassantVulnerable) {
        this.enPassantVulnerable = enPassantVulnerable;
    }

    public ChessPiece getPromoted() {
        return promoted;
    }

    public void setPromoted(ChessPiece promoted) {
        this.promoted = promoted;
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        return possibleMoves(null);
    }

    public ChessPosition performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        return performChessMove(null, null);
    }

    private void initialSetup() {
        board.placePiece(new Rook(board, Color.BLACK), new Position(0,0));
        board.placePiece(new Rook(board, Color.BLACK), new Position(7,0));
        board.placePiece(new Rook(board, Color.WHITE), new Position(7,7));
        board.placePiece(new Rook(board, Color.WHITE), new Position(0,7));
        board.placePiece(new Knight(board, Color.BLACK), new Position(0,1));
        board.placePiece(new Knight(board, Color.BLACK), new Position(0,6));
        board.placePiece(new Knight(board, Color.WHITE), new Position(7,1));
        board.placePiece(new Knight(board, Color.WHITE), new Position(7,6));
        board.placePiece(new Bishop(board, Color.BLACK), new Position(0,2));
        board.placePiece(new Bishop(board, Color.BLACK), new Position(0,5));
        board.placePiece(new Bishop(board, Color.WHITE), new Position(7,2));
        board.placePiece(new Bishop(board, Color.WHITE), new Position(7,5));
        board.placePiece(new King(board, Color.BLACK), new Position(0,4));
        board.placePiece(new King(board, Color.WHITE), new Position(7,4));
        board.placePiece(new Queen(board, Color.BLACK), new Position(0,3));
        board.placePiece(new Queen(board, Color.WHITE), new Position(7,3));
        board.placePiece(new Pawn(board, Color.BLACK), new Position(1,0));
        board.placePiece(new Pawn(board, Color.BLACK), new Position(1,1));
        board.placePiece(new Pawn(board, Color.BLACK), new Position(1,2));
        board.placePiece(new Pawn(board, Color.BLACK), new Position(1,3));
        board.placePiece(new Pawn(board, Color.BLACK), new Position(1,4));
        board.placePiece(new Pawn(board, Color.BLACK), new Position(1,5));
        board.placePiece(new Pawn(board, Color.BLACK), new Position(1,6));
        board.placePiece(new Pawn(board, Color.BLACK), new Position(1,7));
        board.placePiece(new Pawn(board, Color.WHITE), new Position(6,0));
        board.placePiece(new Pawn(board, Color.WHITE), new Position(6,1));
        board.placePiece(new Pawn(board, Color.WHITE), new Position(6,2));
        board.placePiece(new Pawn(board, Color.WHITE), new Position(6,3));
        board.placePiece(new Pawn(board, Color.WHITE), new Position(6,4));
        board.placePiece(new Pawn(board, Color.WHITE), new Position(6,5));
        board.placePiece(new Pawn(board, Color.WHITE), new Position(6,6));
        board.placePiece(new Pawn(board, Color.WHITE), new Position(6,7));
    }

}
