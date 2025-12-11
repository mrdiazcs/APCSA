package Unit2;
/*
 * INSTRUCTIONS:
 * 
 * Fill in all methods to fit the given specifications
 * Each method will ask you to use nested for loops in order
 * to generate some sort of pattern. Feel free to use
 * the main method for testing purposes.
 */

public class PatternPuzzles {

	public static void main(String[] args) {
		rectangle(4, 5);
		//System.out.println();
		triangle(6);
		//System.out.println();
		squareWithDiagonal(6);
		//System.out.println();
		diagonalWithBorders(5);
		//System.out.println();
		diamond(5);
	}
	
	/* 
	 * Prints a rectangle made of the * character
	 * with dimensions h x w
	 * 
	 * For example, rectangle(4, 5) prints
	 * 
	 * 	*****
	 * 	*****
	 * 	*****
	 * 	*****
	 */
	public static void rectangle(int h, int w) {
		
		//your code here
		
	}
	
	/* 
	 * Prints a right triangle made of the * 
	 * character with height h.
	 * 
	 * For example, triangle(6) prints
	 * 
	 * 	*
	 * 	**
	 * 	***
	 * 	****
	 * 	*****
	 * 	******
	 */
	public static void triangle(int h) {
		
		//your code here	
	
	}
	
	/* 
	 * Prints a square made of the * character
	 * with side length s. The square also has an
	 * empty diagonal line running through it.
	 * 
	 * For example, squareWithDiagonal(6) prints
	 * 
	 * 	  * * * * *
	 * 	*   * * * *
	 * 	* *   * * * 
	 * 	* * *   * *
	 * 	* * * *   *
	 * 	* * * * *  
	 */
	public static void squareWithDiagonal(int s) {
		
		//your code here
	
	}
	
	/*
	 * Prints a diagonal line from top left to
	 * bottom right made of the * character. The
	 * diagonal line should have length s. There
	 * should be vertical borders running along 
	 * either side of the diagonal line as well.
	 * 
	 * For example, diagonalWithBorders(5) prints
	 * 
	 * 	|*    |
	 *	| *   |
	 *	|  *  |
	 *	|   * |
	 *	|    *|
	 */
	public static void diagonalWithBorders(int s) {
		
		//your code here
	
	}
	
	/*
	 * Parameter h is always odd.
	 * Prints a diamond made of the * character
	 * of height and width h.
	 * 
	 * For example, diamond(5) prints
	 * 
	 * 	  *  
	 * 	 *** 
	 * 	*****
	 * 	 *** 
	 * 	  *
	 */
	public static void diamond(int h) {
		
		//your code here
	
	}

}
