package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "N";
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        //above right
        checkMovePiece(mat, -2, 1, true, false);

        //above left
        checkMovePiece(mat, -2, -1, true, false);

        //right above
        checkMovePiece(mat, -1, 2, true, false);

        //right below
        checkMovePiece(mat, 1, 2, true, false);

        //below right
        checkMovePiece(mat, 2, 1, true, false);

        //below left
        checkMovePiece(mat, 2, -1, true, false);

        //left below
        checkMovePiece(mat, -1, -2, true, false);

        //left above
        checkMovePiece(mat, 1, -2, true, false);


        return mat;
    }
}
