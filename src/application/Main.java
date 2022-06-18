package application;

import chess.ChessMatch;
import chess.ChessPosition;

public class Main {
    public static void main(String[] args) {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());

        ChessPosition cp = new ChessPosition('c', 2);


        System.out.println();
    }
}
