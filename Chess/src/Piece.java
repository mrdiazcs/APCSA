import java.util.ArrayList;

/**
 * The Piece class is a generic abstract class that serves as the model for the more specific
 * Bishop, King, Knight, Pawn, Queen, and Rook classes. It contains methods that aid in general
 * piece movement, and the model for the abstract method isValidMove.
 * @author Jared Entin
 * @author Antonio Diaz
 */

public class Piece {
	/**
	 * The row that the piece is currently on
	 */
	int row;
	
	/**
	 * The column that the piece is currently on
	 */
	int col;
	
	/**
	 * The team number of the piece. 0 = white, 1 = black
	 */
	int team; //0 is white; 1 is black
	
	/**
	 * Whether the piece has moved or not
	 */
	boolean moved; //for pawns and knighting
	
	/**
	 * The name of the piece to appear on the board
	 */
	String tag;
	
	/**
	 * Constructor for a generic Piece object. Assigns row, col, team, and tag to given 
	 * values and sets moved to false by default.
	 * @param row The row of the piece
	 * @param col The column of the piece
	 * @param team The team number of the piece. 0 = white, 1 = black
	 * @param tag The String value displayed on the board
	 */
	Piece(int row, int col, int team, String tag){
		this.row = row;
		this.col = col;
		this.team = team;
		this.tag = tag;
		moved = false;
	}
	
	/**
	 * Gets Piece instance at specified row and column
	 * @param r row
	 * @param c column
	 * @param pieces An arraylist of pieces currently on the board
	 * @return Null if no piece at given location. Otherwise, returns piece at location.
	 */
	public Piece pieceAt(int r, int c, ArrayList<Piece> pieces) {
		for(int i = 0; i < pieces.size(); i++) {
			
			if(pieces.get(i).row == r && pieces.get(i).col == c)
				return pieces.get(i);
		}
		return null;
	}
	
	/**
	 * Determines whether specified coordinates are in bounds
	 * @param targetRow Row of target move location
	 * @param targetCol Column of target move location
	 * @return Whether or not the target location is within the bounds of the board
	 */
	public boolean inBounds(int targetRow, int targetCol) {
		if(targetRow > 7 || targetRow < 0 || targetCol > 7 || targetCol < 0) {
			return false; //return false if target is off-board
		}
		return true;
	}
	
	/**
	 * Checks for obstruction between current Piece and target destination. Works for diagonal, horizontal, and vertical paths
	 * @param pieces An arraylist of pieces currently on the board
	 * @param tR Row of target move location
	 * @param tC Column of target move location
	 * @return Whether or not the piece's path is obstructed
	 */
	public boolean checkPath(ArrayList<Piece> pieces, int tR, int tC) {
		
		int x = 0, y = 0;
		
		if (tR - row != 0) {
			y = (tR - row) / Math.abs(tR - row);
		}
		
		if (tC - col != 0) {
			x = (tC - col) / Math.abs(tC - col);
		}
		
		while (!(tR == row && tC == col)) {
			tR -= y;
			tC -= x;
			
			if (pieceAt(tR, tC, pieces) != null && pieceAt(tR, tC, pieces) != this) return false;
		}
		
		return true;
	}
	
	/**
	 * Is this piece's team allowed to move
	 * @param turn Current turn number
	 * @return Whether or not it is the piece's team's turn
	 */
	public boolean isMyTurn(int turn) {
		return turn % 2 != team;
	}
	
	/**
	 * Determines if target destination is actually the current destination
	 * @param r Row of target location
	 * @param c Column of target location
	 * @return Whether the target space is the piece's current space or not
	 */
	public boolean sameSpace(int r, int c) {
		return row == r && col == c;
	}
	
	/**
	 * Compares team of 2 different pieces
	 * @param p Piece to compare teams
	 * @return True if same team. False if not.
	 */
	public boolean sameTeam(Piece p) {
		return p != null && p.team == team;
	}
	
	/**
	 * Is the target vertically oriented
	 * @param c Target column
	 * @return True if the target column is the same as the current column. False if not.
	 */
	public boolean moveIsVertical(int c) {
		return Math.abs(col - c) == 0; 
	}
	
	/**
	 * Is the target horizontally oriented
	 * @param r Target row
	 * @return True if the target row is the same as the current row. False if not.
	 */
	public boolean moveIsHorizontal(int r) {
		return Math.abs(row - r) == 0;
	}
	
	/**
	 * Is the target diagonally oriented
	 * @param r Target row
	 * @param c Target column
	 * @return True if the target move is diagonal. False if not.
	 */
	public boolean moveIsDiagonal(int r, int c) {
		return Math.abs(row - r) == Math.abs(col - c);
	}
	
	/**
	 * Determines if this piece can move to its target space
	 * @param board The 2-D array with pieces on it
	 * @param pieces An ArrayList of pieces currently on the board
	 * @param targetRow Target row
	 * @param targetCol Target column
	 * @param turn Turn number
	 * @param myKing The turn player's king piece
	 * @return Whether the attempted move is legal or not
	 */
	public boolean isValidMove(String[][] board, ArrayList<Piece> pieces, int targetRow, int targetCol, int turn, King myKing) {
		if (!inBounds(targetRow, targetCol) || !isMyTurn(turn) || sameSpace(targetRow, targetCol) || sameTeam(pieceAt(targetRow, targetCol, pieces))) {
			return false;
		}
		
		//return true;
		//Hypothetically check if this move would put the king in check
		int tempR = row;
		int tempC = col;
		row = targetRow;
		col = targetCol;
		
		boolean inCheck = myKing.inCheck(board, pieces, myKing.row, myKing.col, turn);		
		
		row = tempR;
		col = tempC;
		
		return !inCheck;
	}
	
	/**
	 * Move to target (assuming it's valid) and remove any piece found
	 * @param targetRow Target row
	 * @param targetCol Target column
	 * @param pieces An ArrayList of pieces currently on the board
	 */
	public void executeMove(int targetRow, int targetCol, ArrayList<Piece> pieces) {
		Piece p = pieceAt(targetRow, targetCol, pieces);
		if (p != null) {
			pieces.remove(pieceAt(targetRow, targetCol, pieces));
		}
				
		moved = true;
		row = targetRow;
		col = targetCol;
	}

	
}