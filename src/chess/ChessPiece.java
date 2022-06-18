package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    private final Color color;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public Piece[][] possibleMoves() {
        return new Piece[0][0];
    }

    @Override
    public boolean possibleMove(Position position) {
        return false;
    }
}
