package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];


        //above
        checkMovePiece(mat, -1, 0, true, true);

        // left
        checkMovePiece(mat, 0, -1, true, true);

        // right
        checkMovePiece(mat, 0, 1, true, true);

        // below
        checkMovePiece(mat, 1, 0, true, true);

        return mat;
    }
}
