package application;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        while (true) {
            UI.clearScreen();
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.print("Source: ");
            ChessPosition source = UI.readChessPosistion(sc);
            System.out.println();
            System.out.print("Target: ");
            ChessPosition target = UI.readChessPosistion(sc);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
        }
    }
}
