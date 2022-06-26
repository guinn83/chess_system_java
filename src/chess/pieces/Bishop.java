package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        //above left
        checkMovePiece(mat, -1, -1, true, true);

        // above right
        checkMovePiece(mat, -1, 1, true, true);

        // below left
        checkMovePiece(mat, 1, -1, true, true);

        // below right
        checkMovePiece(mat, 1, 1, true, true);

        return mat;
    }

}
