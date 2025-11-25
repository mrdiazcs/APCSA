import java.util.ArrayList;

/**
 * The class for a Knight piece in chess
 * @author Jared Entin
 * @author Antonio Diaz
 */

public class Knight extends Piece{

	/**
	 * Calls the parent class' constructor with given parameters
	 * @param row Current row
	 * @param col Current column
	 * @param team Team number
	 * @param tag Display string
	 */
	Knight(int row, int col, int team, String tag) {
		super(row, col, team, tag);
	}
	
	public boolean isValidMove(String[][] board, ArrayList<Piece> pieces, int targetRow, int targetCol, int turn, King k) {
		if (!super.isValidMove(board, pieces, targetRow, targetCol, turn, k)) return false;
		
		if(targetRow == row - 2 && targetCol == col - 1) {
			return true; //up and left
		}
		
		if(targetRow == row - 2 && targetCol == col + 1) {
			return true; //up and right
		}
		
		if(targetRow == row - 1 && targetCol == col + 2) {
			return true; //right and up
		}
		
		if(targetRow == row + 1 && targetCol == col + 2) {
			return true; //right and down
		}
		
		if(targetRow == row + 2 && targetCol == col - 1) {
			return true; //down and left
		}
		
		if(targetRow == row + 2 && targetCol == col + 1) {
			return true; //down and right
		}
		
		if(targetRow == row - 1 && targetCol == col - 2) {
			return true; //left and up
		}
		
		if(targetRow == row + 1 && targetCol == col - 2) {
			return true; //left and down
		}
		
		return false; //return false if illegal movement pattern detected
	}
}