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

        int colorMove = getColor() == Color.WHITE ? -1 : 1;

        //mover
        checkMovePiece(mat, colorMove, 0, false, false);
        Position p2 = new Position(position.getRow() + colorMove, position.getColumn());
        if (getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
            checkMovePiece(mat, getColor() == Color.WHITE ? -2 : 2, 0, false, false);
        }
        //mover e capturar
        p2.setValues(position.getRow() + colorMove, position.getColumn() - 1);
        if (getBoard().positionExists(p2) && isThereOpponentPiece(p2)) {
            checkMovePiece(mat, colorMove, -1, true, false);
        }
        p2.setValues(position.getRow() + colorMove, position.getColumn() + 1);
        if (getBoard().positionExists(p2) && isThereOpponentPiece(p2)) {
            checkMovePiece(mat, colorMove, 1, true, false);
        }

        return mat;
    }



    @Override
    public String toString() {
        return "P";
    }

}
