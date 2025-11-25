import java.util.ArrayList;

//Javadoc comments

/**
 * The class for a Pawn in chess
 * @author Jared Entin
 * @author Antonio Diaz
 */

public class Pawn extends Piece {
	
	/**
	 * Direction of the pawn used for pawn promotion
	 */
	int direction;
	/**
	 * Turn on which a pawn moved 2 spaces
	 */
	int doubTurn;	//only for en passant functionality
	
	/**
	 * Calls the parent class' constructor with given parameters. Sets direction to given value
	 * @param row Current row
	 * @param col Current column
	 * @param team Team number
	 * @param tag Display string
	 * @param direction The direction in which the pawn is moving
	 */
	Pawn(int row, int col, int team, String tag, int direction) {
		super(row, col, team, tag);
		this.direction = direction;
	}
	
	/**
	 * Determines if the attempted diagonal move is legal
	 * @param r Target row
	 * @param c Target column
	 * @param distance Distance the pawn should travel
	 * @return Whether the move is legal or not
	 */
	public boolean validDiagonal(int r, int c, int distance) {
		return Math.abs(row - r) == distance && Math.abs(col - c) == distance;
	}
	
	public void executeMove(int targetRow, int targetCol, ArrayList<Piece> pieces) {

		if (validDiagonal(targetRow, targetCol, 1)) {
			if (pieceAt(targetRow, targetCol, pieces) != null) {
				pieces.remove(pieceAt(targetRow, targetCol, pieces));
			} else if (pieceAt(targetRow - direction, targetCol, pieces) != null) {
				pieces.remove(pieceAt(targetRow - direction, targetCol, pieces));
			}
		}
		
		//En Passant handling
		if (doubTurn == 1) doubTurn = 0;
		if (!moved && Math.abs(row - targetRow) == 2) doubTurn = 1;
		
		moved = true;
		row = targetRow;
		col = targetCol;

		int r = ((-direction % 7 + 7) % 7) + direction;	//Determine which end of the board enables promotion depending on pawn direction
		if (row == r) //Check for promotion
		{
			promote(pieces);
		}
	}
	
	public boolean isValidMove(String[][] board, ArrayList<Piece> pieces, int targetRow, int targetCol, int turn, King k) {
		if (!super.isValidMove(board, pieces, targetRow, targetCol, turn, k)) return false;

		if (Math.abs(row - targetRow) > 2) return false;				//Pawn can only move <= 2 spaces

		if (targetRow == row + (direction * 2) && moved) return false; 	//Only a pawn's first move can be 2 spaces (en passant)
				
		if ((row - targetRow) * direction > 0) return false;			//Pawns can't move backward

		if (validDiagonal(targetRow, targetCol, 1)) {
			Piece p = pieceAt(targetRow, targetCol, pieces);

			if (p != null) {
				if (p.team == team) return false;
				
				return true;
			}
			
			Piece pEP = pieceAt(targetRow - direction, targetCol, pieces);
			
			if (pEP != null && pEP instanceof Pawn) {
				if (pEP.team == team) return false;

				if (((Pawn)pEP).doubTurn == 1) return true;
			}
		}
		
		return targetCol == col;
	}
	
	/**
	 * Promote piece to either a Knight, Bishop, Rook, or Queen
	 * Precondition: A pawn has reached the other side of the board
	 * Postcondition: The promoted pawn now can move like a Knight, Bishop, Rook, or Queen
	 * @param pieces An ArrayList of pieces currently on the board
	 */
	public void promote(ArrayList<Piece> pieces) {
		
		String teamLabel;
		if (team == 0) { //white
			teamLabel = "w";
		} else {		 //black
			teamLabel = "b";
		}
		pieces.remove(this);
		
		
		if (Chess.promoteText.equals("N")) {
			pieces.add(new Knight(row, col, team, new String(teamLabel + "N")));
		}
		else if (Chess.promoteText.equals("B")) {
			pieces.add(new Bishop(row, col, team, new String(teamLabel + "B")));
		}
		else if (Chess.promoteText.equals("R")) {
			pieces.add(new Rook(row, col, team, new String(teamLabel + "R")));
		}
		else if (Chess.promoteText.equals("Q") || Chess.promoteText.equals("")) {
			pieces.add(new Queen(row, col, team, new String(teamLabel + "Q")));
		}
	}

}
