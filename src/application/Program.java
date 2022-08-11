package application;

import java.util.Scanner;

import boardgame.Board;
import boardgame.Position;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Board board = new Board(8, 8);
		
		System.out.print(board.getColumns());
		
		sc.close();

	}

}
