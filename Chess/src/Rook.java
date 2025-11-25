import java.util.ArrayList;

/**
 * The class for a Rook piece in chess
 * @author Jared Entin
 * @author Antonio Diaz
 */

public class Rook extends Piece{
	
	/**
	 * Calls the parent class' constructor with given parameters
	 * @param row Current row
	 * @param col Current column
	 * @param team Team number
	 * @param tag Display string
	 */
	Rook(int row, int col, int team, String tag) {
		super(row, col, team, tag);
	}
	
	public boolean isValidMove(String[][] board, ArrayList<Piece> pieces, int targetRow, int targetCol, int turn, King k) {
		if (!super.isValidMove(board, pieces, targetRow, targetCol, turn, k)) return false;
		
		if (!moveIsVertical(targetCol) && !moveIsHorizontal(targetRow)) return false;
		
		if (!checkPath(pieces, targetRow, targetCol)) return false;
		
		return true; //return true if no illegal move checks return false
	}
}