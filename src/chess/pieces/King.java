package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

       //above left
        checkMovePiece(mat, -1, -1, true, false);
         //above
        checkMovePiece(mat, -1, 0, true, false);
         //above right
        checkMovePiece(mat, -1, 1, true, false);
         //right
        checkMovePiece(mat, 0, 1, true, false);
         //below right
        checkMovePiece(mat, 1, 1, true, false);
         //below
        checkMovePiece(mat, 1, 0, true, false);
         //below left
        checkMovePiece(mat, 1, -1, true, false);
         //left
        checkMovePiece(mat, 0, -1, true, false);

        return mat;
    }
}
