package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {
    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "Q";
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        //above left
        checkMovePiece(mat, -1, -1, true, true);

        //above
        checkMovePiece(mat, -1, 0, true, true);

        //above right
        checkMovePiece(mat, -1, 1, true, true);

        //right
        checkMovePiece(mat, 0, 1, true, true);

        //below right
        checkMovePiece(mat, 1, 1, true, true);

        //below
        checkMovePiece(mat, 1, 0, true, true);

        //below left
        checkMovePiece(mat, 1, -1, true, true);

        //left
        checkMovePiece(mat, 0, -1, true, true);

        return mat;
    }
}
