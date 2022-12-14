package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		while (!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.printf("%nSource (C/R): ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.printf("%nTarget (C/R): ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				if (capturedPiece != null) {
					captured.add(capturedPiece);					
				}
				
				if (chessMatch.getPromoted() != null) {
					System.out.print("Piece for Promotion (B/H/R/Q): ");
					String type = sc.nextLine().toUpperCase();
					while (!type.equals("B") && !type.equals("H") && !type.equals("R") & !type.equals("Q")) {
						System.out.print("Invalid Value! Piece for Promotion (B/H/R/Q): ");
						type = sc.nextLine().toUpperCase();
					}
					chessMatch.replacePromotedPiece(type);
				}
			}
			catch (ChessException e){
				System.out.println();
				System.out.println(UI.ANSI_RED + e.getMessage() + UI.ANSI_RESET);
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}

}
