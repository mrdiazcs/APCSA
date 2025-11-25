
import java.util.ArrayList;

/**
 * The class for a Bishop piece in chess
 * @author Jared Entin
 * @author Antonio Diaz
 */

public class Bishop extends Piece{
	
	/**
	 * Calls the parent class' constructor with given parameters
	 * @param row Current row
	 * @param col Current column
	 * @param team Team number
	 * @param tag Display string
	 */
	Bishop(int row, int col, int team, String tag) {
		super(row, col, team, tag);
	}
	
	/**
	 * Calls parent class' isValidMove method. Checks that move is diagonal and that path is clear.
	 */
	public boolean isValidMove(String[][] board, ArrayList<Piece> pieces, int targetRow, int targetCol, int turn, King k) {
		if (!super.isValidMove(board, pieces, targetRow, targetCol, turn, k)) return false;
		
		if (!moveIsDiagonal(targetRow, targetCol)) return false;
		
		if (!checkPath(pieces, targetRow, targetCol)) return false;
			
		return true;	
	}
}