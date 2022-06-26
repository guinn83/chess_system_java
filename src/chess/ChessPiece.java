package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    private final Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public ChessPosition getChessPosistion() {
        return ChessPosition.fromPosition(position);
    }

    protected void increaseMoveCount() {
        moveCount++;
    }

    protected void decreaseMoveCount() {
        moveCount--;
    }

    public Color getColor() {
        return color;
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

    protected void checkMovePiece(boolean[][] mat, int offsetRow, int offsetColumn, boolean canCapture, boolean whileOn) {
        Position p = new Position(0, 0);
        p.setValues(position.getRow() + offsetRow, position.getColumn() + offsetColumn);

        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            if (!whileOn) break;
            p.setValues(p.getRow() + offsetRow, p.getColumn() + offsetColumn);
        }
        if (canCapture && getBoard().positionExists(p) && isThereOpponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    }

}
