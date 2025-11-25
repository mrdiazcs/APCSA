import java.util.ArrayList;

/**
 * The class for a King piece in chess
 * @author Jared Entin
 * @author Antonio Diaz
 */

public class King extends Piece{
	
	/**
	 * Boolean variable to represent whether or not the king is castling
	 */
	boolean castling = false;
	
	/**
	 * Calls the parent class' constructor with given parameters
	 * @param row Current row
	 * @param col Current column
	 * @param team Team number
	 * @param tag Display string
	 */
	King(int row, int col, int team, String tag) {
		super(row, col, team, tag);
	}
	
	/**
	 * Executes attempted move. Allows for castling.
	 */
	public void executeMove(int targetRow, int targetCol, ArrayList<Piece> pieces) {
		
		if (castling) {
			//System.out.println("col: " + col + ", target col: " + targetCol);
			int direction = (targetCol - col) / Math.abs(targetCol - col);	//+ direction == right castle, - direction == left castle
			int castlingRookCol = ((-direction % 7 + 7) % 7) + direction;
			int jumpedSqCol = col + direction;
			
			//Move Rook
			pieceAt(row, castlingRookCol, pieces).moved = true;
			pieceAt(row, castlingRookCol, pieces).col  = jumpedSqCol;
			
			//Move King
			col = targetCol;
		
			castling = false;
			
		} else {
			Piece p = pieceAt(targetRow, targetCol, pieces);
			//System.out.println("Removing?: " + p);
			if (p != null) {
				pieces.remove(pieceAt(targetRow, targetCol, pieces));
			}
					
			moved = true;
			row = targetRow;
			col = targetCol;
		}
	}
	
	/**
	 * Calls parent class' isValidMove method. Then checks that the king is not in check.
	 */
	public boolean isValidMove(String[][] board, ArrayList<Piece> pieces, int targetRow, int targetCol, int turn, King k) {
		if (!super.isValidMove(board, pieces, targetRow, targetCol, turn, k)) return false;

		if (inCheck(board, pieces, targetRow, targetCol, (turn + 1) % 2)) return false;	//Would this potential move put the King in Check for the next team's move?
		
		if (!moved && !inCheck(board, pieces, targetRow, targetCol, (turn + 1) % 2)) {
			
			if (Math.abs(targetCol - col) == 2) { //Moving 2 spaces means castling attempt
				//System.out.println("castle attempt");
				
				int direction = (targetCol - col) / Math.abs(targetCol - col);	//+ direction == right castle
																				//- direction == left castle
				int castlingRookCol = ((-direction % 7 + 7) % 7) + direction;
				
				int jumpedSqCol = col + direction;
				
				if (!checkPath(pieces, row, castlingRookCol)) return false;	//Path should be clear between King and Rook
				
				if (pieceAt(row, castlingRookCol, pieces).team != team) return false;
				
				if (!(pieceAt(row, castlingRookCol, pieces) instanceof Rook)) return false;
				
				if (pieceAt(row, castlingRookCol, pieces).moved) return false;		//Castling Rook must not have moved
				
				if (inCheck(board, pieces, row, jumpedSqCol, (turn + 1) % 2)) return false;	//Square King jumps over can't be in check

				castling = true;
				
				return true;
			}
		}
		
		if(!moveIsVertical(targetCol) && !moveIsHorizontal(targetRow) && !moveIsDiagonal(targetRow, targetCol))	return false;

		if(Math.abs(targetRow - row) > 1 || Math.abs(targetCol - col) > 1) {
			return false; //return false if trying to move king too far
		}
		
		return true; //return true if no illegal move checks return false
	}
	
	/**
	 * Checks that this king is not in check
	 * @param board The 2-D array containing the pieces and spaces
	 * @param pieces An ArrayList of the pieces currently on the board
	 * @param r Target row
	 * @param c Target column
	 * @param turn Current turn
	 * @return Whether or not the king is in check
	 */
	boolean inCheck(String[][] board, ArrayList<Piece> pieces, int r, int c, int turn) {
		for (int i = 0; i < pieces.size(); i++) {
			if (pieces.get(i).team == team) continue;
			if (pieces.get(i) instanceof King) continue;
			
			if (pieces.get(i).isValidMove(board, pieces, r, c, (turn + 1) % 2, this)) return true;
		}
		return false;
	}
}