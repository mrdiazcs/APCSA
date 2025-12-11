package Unit2;

public class PatternPuzzlesAnswers {

	public static void main(String[] args) {
		rectangle(4, 5);
		System.out.println();
		triangle(6);
		System.out.println();
		squareWithDiagonal(6);
		System.out.println();
		diagonalWithBorders(5);
		System.out.println();
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
		for (int row=0; row<h; row++) { //controls the # of rows
			for (int col=0; col<w; col++) { //controls the # of cols
				System.out.print("*");
			}
			System.out.println();
		}
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
		for (int row=0; row<h; row++) {
			for (int col=0; col<=row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}	
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
		for (int row=1; row<=s; row++) {
			for (int col=1; col<=s; col++) {
				if(row==col) {
					System.out.print("  ");
				}
				else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
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
		for (int row=1; row<=s; row++) { //going from row to row
			System.out.print("|"); //at the start of a new line
			for (int col=1; col<=s; col++) { //prints a new line
				if(row==col) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("|"); //at the end of a new line
		}
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
		for(int i = 0; i <= h; i++) {
			for(int j = 0; j < h; j++) {
				if(i <= h / 2) {
					if(j >= h / 2 - i && j <= h / 2 + i) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
				else {
					int k = h - i - 1;
					if(j >= h / 2 - k && j <= h / 2 + k) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

}
