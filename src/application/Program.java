package application;

import java.util.Scanner;

import boardgame.BoardException;
import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		try {
			ChessMatch chessMatch = new ChessMatch();
			UI.printBoard(chessMatch.getPieces());
		}
		catch (BoardException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();

	}

}
