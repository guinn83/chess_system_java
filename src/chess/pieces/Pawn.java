package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;
    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        int colorMove = (getColor() == Color.WHITE) ? -1 : 1;

        //mover
        checkMovePiece(mat, colorMove, 0, false, false);
        Position p = new Position(position.getRow() + colorMove, position.getColumn());
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0) {
            checkMovePiece(mat, getColor() == Color.WHITE ? -2 : 2, 0, false, false);
        }

        //mover e capturar
        p.setValues(position.getRow() + colorMove, position.getColumn() - 1);
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            checkMovePiece(mat, colorMove, -1, true, false);
        }
        p.setValues(position.getRow() + colorMove, position.getColumn() + 1);
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            checkMovePiece(mat, colorMove, 1, true, false);
        }

        //enPassant logic
        if (position.getRow() == (getColor() == Color.WHITE ? 3 : 4)) {
            Position left = new Position(position.getRow(), position.getColumn() - 1);
            if (getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                mat[left.getRow() + colorMove][left.getColumn()] = true;
            }
            Position right = new Position(position.getRow(), position.getColumn() + 1);
            if (getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                mat[right.getRow() + colorMove][right.getColumn()] = true;
            }
        }

        return mat;
    }



    @Override
    public String toString() {
        return "P";
    }

}
