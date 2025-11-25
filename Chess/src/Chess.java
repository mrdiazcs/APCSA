import java.util.Scanner;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * The Chess class contains a main method that builds 
 * a board, populates it, and runs a game of chess
 * @author Jared Entin
 * @author Antonio Diaz
 */

public class Chess {
	/**
	 * The scanner that reads user input
	 */
	static Scanner scan;
	
	/**
	 * A String field to hold information about how to promote a pawn
	 */
	static String promoteText = "";
	
	/**
	 * A boolean variable to keep track of illegal move attempts
	 */
	static boolean illegalAttempt = false;
	
	/**
	 * The main method creates a new ArrayList to hold pieces, populates that list with a starting
	 * set of pieces, and then loops until the game of chess is over. 
	 * <p>
	 * The loop asks for user input, parses it, and then either ends the game (resign or draw) or moves
	 * pieces accordingly. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		
		ArrayList<Piece> pieces = new ArrayList<>();
		
		//create white team
		Piece wr1 = new Rook(7, 0, 0, "\u2656");
		Piece wn1 = new Knight(7, 1, 0, "\u2658");
		Piece wb1 = new Bishop(7, 2, 0, "\u2657");
		Piece wq = new Queen(7, 3, 0, "\u2655");
		Piece wk = new King(7, 4, 0, "\u2654");
		Piece wb2 = new Bishop(7, 5, 0, "\u2657");
		Piece wn2 = new Knight(7, 6, 0, "\u2658");
		Piece wr2 = new Rook(7, 7, 0, "\u2656");
		Piece wp1 = new Pawn(6, 0, 0, "\u2659", -1);
		Piece wp2 = new Pawn(6, 1, 0, "\u2659", -1);
		Piece wp3 = new Pawn(6, 2, 0, "\u2659", -1);
		Piece wp4 = new Pawn(6, 3, 0, "\u2659", -1);
		Piece wp5 = new Pawn(6, 4, 0, "\u2659", -1);
		Piece wp6 = new Pawn(6, 5, 0, "\u2659", -1);
		Piece wp7 = new Pawn(6, 6, 0, "\u2659", -1);
		Piece wp8 = new Pawn(6, 7, 0, "\u2659", -1);
		
		//create black team
		Piece br1 = new Rook(0, 0, 1, "\u265C");
		Piece bn1 = new Knight(0, 1, 1, "\u265E");
		Piece bb1 = new Bishop(0, 2, 1, "\u265D");
		Piece bq = new Queen(0, 3, 1, "\u265B");
		Piece bk = new King(0, 4, 1, "\u265A");
		Piece bb2 = new Bishop(0, 5, 1, "\u265D");
		Piece bn2 = new Knight(0, 6, 1, "\u265E");
		Piece br2 = new Rook(0, 7, 1, "\u265C");
		Piece bp1 = new Pawn(1, 0, 1, "\u265F", 1);
		Piece bp2 = new Pawn(1, 1, 1, "\u265F", 1);
		Piece bp3 = new Pawn(1, 2, 1, "\u265F", 1);
		Piece bp4 = new Pawn(1, 3, 1, "\u265F", 1);
		Piece bp5 = new Pawn(1, 4, 1, "\u265F", 1);
		Piece bp6 = new Pawn(1, 5, 1, "\u265F", 1);
		Piece bp7 = new Pawn(1, 6, 1, "\u265F", 1);
		Piece bp8 = new Pawn(1, 7, 1, "\u265F", 1);
		
		//add white team to array
		pieces.add(wr1);
		pieces.add(wn1);
		pieces.add(wb1);
		pieces.add(wk);
		pieces.add(wq);
		pieces.add(wb2);
		pieces.add(wn2);
		pieces.add(wr2);
		pieces.add(wp1);
		pieces.add(wp2);
		pieces.add(wp3);
		pieces.add(wp4);
		pieces.add(wp5);
		pieces.add(wp6);
		pieces.add(wp7);
		pieces.add(wp8);
		
		//add black team to array
		pieces.add(br1);
		pieces.add(bn1);
		pieces.add(bb1);
		pieces.add(bk);
		pieces.add(bq);
		pieces.add(bb2);
		pieces.add(bn2);
		pieces.add(br2);
		pieces.add(bp1);
		pieces.add(bp2);
		pieces.add(bp3);
		pieces.add(bp4);
		pieces.add(bp5);
		pieces.add(bp6);
		pieces.add(bp7);
		pieces.add(bp8);
		
		String[][] board = new String[9][9];
		
		int turn = 1;
//		
//		int startRow = 0;
//		int startCol = 0;
//		int targetRow = 0;
//		int targetCol = 0;
		
		boolean drawRequested = false;
		
		drawBoard(board, pieces);
		scan = new Scanner(System.in);
		
		//Loop is broken when game ends
		while(true) {
			if(turn % 2 == 1) {
				System.out.print("White's move: ");
			}
			else {
				System.out.print("Black's move: ");
			}
			
			String s = scan.nextLine();
			
			//parse input
			
			//Has a draw been requested?
			if (drawRequested) {
				if (s.equals("draw")) {
					endGame(-1);
					break;
				}
			}
			
			if (checkResignation(s, turn % 2)) {
				break;
			}
			
			
			King myKing;
			King enemyKing;
			if (turn % 2 == 0) { //Black's turn
				myKing = (King) bk;
				enemyKing = (King) wk;
			} else {
				myKing = (King) wk;
				enemyKing = (King) bk;
			}
			
			//Standard move
			if (!checkRegularMove(s, turn % 2, board, pieces, myKing)) {
				continue;
			}
			
			//System.out.println("checking index of");
			if (findKing(pieces, whoseTurn((turn + 1) % 2)) == null) {

				endGame(turn);
				break;
			}
			
			//Check if King in check
			if (enemyKing.inCheck(board, pieces, enemyKing.row, enemyKing.col, (turn + 1) % 2)) {
				if (inCheckmate(board, pieces, enemyKing, (turn + 1) % 2)) {
					System.out.println("Checkmate");
					endGame(turn);
					break;
				}
				System.out.println("Check");
			}
			//Has the player requested a draw at after this move?
			drawRequested = checkDrawRequest(s, drawRequested);
				
			//Redraw, next turn
			System.out.println();
			drawBoard(board, pieces);
			turn++;			
		}
	}
	
	/**
	 * This method takes a given row/column coordinate and returns the piece at that coordinate
	 * @param r row
	 * @param c	column
	 * @param pieces An arraylist of pieces currently on the board
	 * @return The piece currently located at the given row and column
	 */
	static Piece pieceAt(int r, int c, ArrayList<Piece> pieces) {
		for(int i = 0; i < pieces.size(); i++) {
			if(pieces.get(i).row == r && pieces.get(i).col == c)
				return pieces.get(i);
		}
		return null;
	}
	
	/**
	 * This method takes a given row/column coordinate and returns a boolean value
	 * that corresponds to whether that space on the board is occupied or not
	 * @param r row
	 * @param c column
	 * @param pieces An arraylist of pieces currently on the board
	 * @return A boolean variable for whether the space is occupied or not
	 */
	static boolean openSpace(int r, int c, ArrayList<Piece> pieces) {
		for(int i = 0; i < pieces.size(); i++) {
			if(pieces.get(i).row == r && pieces.get(i).col == c)
				return false;
		}
		return true;		
	}
	
	/**
	 * This method takes a given row/column coordinate and returns the 
	 * tag of the space located at that spot on the board
	 * @param r row
	 * @param c column
	 * @param pieces An arraylist of pieces currently on the board
	 * @return The tag of the piece occupying that space on the board
	 */
	static String tagForSpace(int r, int c, ArrayList<Piece> pieces) {
		for(int i = 0; i < pieces.size(); i++) {
			if(pieces.get(i).row == r && pieces.get(i).col == c)
				return pieces.get(i).tag;
		}
		return null;
	}
	
	/**
	 * whose turn is it
	 * @param int turn
	 * @return int team number
	 */
	static int whoseTurn(int turn) {
		return (turn + 1) % 2;
	}
	
	/**
	 * This method draws the board at any given state
	 * @param board A 2-D String array of empty spaces and Piece tags to simulate a game board
	 * @param pieces An arraylist of pieces currently on the board
	 */
	public static void drawBoard(String[][] board, ArrayList<Piece> pieces) {
		boolean blackSpace = false;
		for(int i = 0; i < 8; i++) {
			if (i % 2 == 0) {
				blackSpace = false;
			} else {
				blackSpace = true;
			}
			for(int j = 0; j < 8; j++) {
				if (openSpace(i, j, pieces)) {
					if (blackSpace) {
						board[i][j] = "#";
					} else {
						board[i][j] = " ";
					}
				} else {
					board[i][j] = tagForSpace(i, j, pieces);
				}
				blackSpace = !blackSpace;
			}
			board[i][8] = Integer.toString(8-i);
		}
		board[8][0] = "a";
		board[8][1] = "b";
		board[8][2] = "c";
		board[8][3] = "d";
		board[8][4] = "e";
		board[8][5] = "f";
		board[8][6] = "g";
		board[8][7] = "h";
		board[8][8] = "";
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * Checks if a draw has been requested by another player
	 * @param s the full text of the user input line
	 * @return boolean value corresponding to whether a draw was requested or not
	 */
	static boolean checkDrawRequest(String s, boolean dr) {
		String[] wordArray = s.split(" ");				
		if(dr && illegalAttempt) {
			return true;
		}
		if (wordArray.length > 2) {
			if (wordArray[wordArray.length - 1].equals("draw?")){
				return true;			
			}
		}
		return false;
	}
	
	/**
	 * Prints the winner of the game
	 * @param winner int value corresponding to the team that won. -1 for draw.
	 */
	static void endGame(int winner) {
		switch (winner) {
			case -1:
				System.out.println("draw");
				break;
			case 0:
				System.out.println("White wins");
				break;
			case 1:
				System.out.println("Black wins");
				break;
		}
	}
	
	/**
	 * 
	 * @param s
	 * @param turn
	 * @return
	 */
	static boolean checkResignation(String s, int turn) {
		if (s.equals("resign")) {
			endGame(turn);
			return true;
		}
		return false;
	}
	
	/**
	 * Finds the king of a given team
	 * @param pieces An arraylist of pieces currently on the board
	 * @param team The team of the king that the method is supposed to find
	 * @return The piece that is the king of the corresponding team
	 */
	static Piece findKing(ArrayList<Piece> pieces, int team) {
		for (int i = 0; i < pieces.size(); i++) {
			//System.out.println(pieces.get(i));
			if (pieces.get(i).team != team) continue;
			
			

			if (pieces.get(i) instanceof King) return pieces.get(i);
		}
		
		return null;
	}
	
	/**
	 * Checks if the given move is legal. If so, the move is executed. If not, a message is printed to the user.
	 * @param s The user input
	 * @param turn The turn number
	 * @param board The board array in its current state
	 * @param pieces An arraylist of pieces currently on the board
	 * @param myKing The object corresponding to the current player's king
	 * @return Whether or not the attempted move is legal
	 */
	static boolean checkRegularMove(String s, int turn, String[][] board, ArrayList<Piece> pieces, King myKing) {
		
		int startRow = 0;
		int startCol = 0;
		int targetRow = 0;
		int targetCol = 0;

		String[] sArray = s.split("");
		String[] wordArray = s.split(" ");
		
		for(int i = 0; i < sArray.length; i++) {

			switch(i) {
				case 0:
					switch(sArray[0]) {
						case "a":
							startCol = 0;
							break;
						case "b":
							startCol = 1;
							break;
						case "c":
							startCol = 2;
							break;
						case "d":
							startCol = 3;
							break;
						case "e":
							startCol = 4;
							break;
						case "f":
							startCol = 5;
							break;
						case "g":
							startCol = 6;
							break;
						case "h":
							startCol = 7;
							break;
					}
					break;
				case 1:
					startRow = 8 - Integer.parseInt(sArray[1]);
					break;
				case 2:
					break;
				case 3:
					switch(sArray[3]) {
						case "a":
							targetCol = 0;
							break;
						case "b":
							targetCol = 1;
							break;
						case "c":
							targetCol = 2;
							break;
						case "d":
							targetCol = 3;
							break;
						case "e":
							targetCol = 4;
							break;
						case "f":
							targetCol = 5;
							break;
						case "g":
							targetCol = 6;
							break;
						case "h":
							targetCol = 7;
							break;
					}
					break;
				case 4:
					targetRow = 8 - Integer.parseInt(sArray[4]);
					break;
			}

		}

		if (wordArray.length > 2) {
			promoteText = wordArray[2];
		}
		
		//Polymorphism start
		
		Piece target = pieceAt(startRow, startCol, pieces);

		if(target != null && target.isValidMove(board, pieces, targetRow, targetCol, turn, myKing)) {
			//Polymorphism end
			
			illegalAttempt = false;
			target.executeMove(targetRow, targetCol, pieces);
			promoteText = "";

			return true;
		} 
		
		illegalAttempt = true;
		System.out.println("Illegal move, try again");
		return false;
	}
	
	/**
	 * Checks if the current player's king is in checkmate
	 * @param board The 2-D array containing the tags of all of the pieces
	 * @param pieces An arraylist of pieces currently on the board
	 * @param k The next player's king
	 * @param turn The current turn number
	 * @return Whether or not the current player's king is in check
	 */
	static boolean inCheckmate(String[][] board, ArrayList<Piece> pieces, King k, int turn) {
		
//		int[][] directions = { {-1,-1}, {-1, 0}, {-1, 1},
//							   {0,-1}, {0, 0}, {0, 1},
//							   {1,-1}, {1, 0}, {1, 1} };

		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (k.isValidMove(board, pieces, k.row + i, k.col + j, turn, k)) {
					return false;
				}
			}
		}
		
		//NEW CODE BELOW
		
		String[][] simBoard = board;
		ArrayList<Piece> simPieces = new ArrayList<Piece>();
													
		for(int p = 0; p < pieces.size(); p++) {//for every piece
			simPieces.add(pieces.get(p)); //add it to a sim board
		}
		
		for(int p = 0; p < simPieces.size(); p++) {
			Piece t = simPieces.get(p);
			for(int i = 0; i < 8; i++) {//Cycle through all spaces
				for(int j = 0; j < 8; j++) {//Check every piece
					if(t.isValidMove(simBoard, simPieces, i, j, turn + 1, k)) {  	//If piece can move
						t.executeMove(i, j, simPieces);								//move it
						if(!(k.inCheck(simBoard, simPieces, i, j, turn + 1))) { 	//is king still in check?
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
		
}
